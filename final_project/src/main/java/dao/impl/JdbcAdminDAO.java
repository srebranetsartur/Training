package dao.impl;

import dao.AdminDAO;
import dao.exceptions.DaoException;
import dao.mapper.RowMapper;
import dao.transaction.SQLOperation;
import dao.transaction.TransactionHandler;
import db.DataSourceFactory;
import entities.Administrator;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.sql.DataSource;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JdbcAdminDAO implements AdminDAO {
    private DataSource dataSource;

    public JdbcAdminDAO() {
        this.dataSource = DataSourceFactory.getDataSource();
    }

    private RowMapper<Administrator> adminRowMapper = (rs) -> {
        String login = rs.getString("login");
        String password = rs.getString("password");
        String firstName = rs.getString("firstname");
        String lastName = rs.getString("lastname");
        String number = rs.getString("number");
        LocalDate birthday = rs.getObject("birthday", LocalDate.class);

        return new Administrator(login, password, firstName, lastName, birthday, number);
    };

    @Override
    public Administrator save(Administrator administrator) {

        SQLOperation<Connection, Administrator> sqlOperation = (connection) -> {
            try {
                PreparedStatement statement = connection
                        .prepareStatement("insert into administrator(login, password, first_name, last_name, birthday, number) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, administrator.getLogin());
                statement.setString(2, encodePassword(administrator.getPassword()));
                statement.setString(3, administrator.getFirstName());
                statement.setString(4, administrator.getLastName());
                statement.setObject(5, administrator.getBirthday());
                statement.setString(6, administrator.getNumber());

                int rowExecuted = statement.executeUpdate();

                if (rowExecuted > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        long adminId = generatedKeys.getLong(1);
                        administrator.setID(adminId);
                    }
                }
            }
            catch (SQLException e) {
                throw new DaoException(e);
            }

            return administrator;
        };

        try {
            return TransactionHandler.doInTransaction(dataSource, sqlOperation);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }


    @Override
    public void delete(Administrator entity) {

    }

    @Override
    public Administrator update(Administrator entity) {
        return entity;
    }

    @Override
    public Optional<Administrator> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Administrator> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Administrator> findByLoginAndPassword(String login, String password) {
        try(Connection connection = dataSource.getConnection()) {

            try (PreparedStatement statement = connection.prepareStatement("select * from administrator where login = ?")) {
                statement.setString(1, login);

                ResultSet rs = statement.executeQuery();
                if (rs.next() || validatePassword(password, rs.getString("password"))) {
                    Administrator administrator = adminRowMapper.mapToObject(rs);
                    return Optional.of(administrator);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private String encodePassword(String password) {
        try {
            //Generate salts
            SecureRandom random = new SecureRandom();
            int iteration = 100000;
            int keyStrength = 512;
            byte[] salt = new byte[16];
            random.nextBytes(salt);


            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iteration , keyStrength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hashBytes = factory.generateSecret(spec).getEncoded();

            return iteration + ":" + Hex.encodeHexString(salt) + ":" + Hex.encodeHexString(hashBytes);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validatePassword(String originalPassword, String storedPassword) throws DecoderException, NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = Hex.decodeHex(parts[1].toCharArray());
        byte[] hash = Hex.decodeHex(parts[2].toCharArray());

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
}
