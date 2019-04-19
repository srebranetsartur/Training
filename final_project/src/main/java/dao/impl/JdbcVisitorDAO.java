package dao.impl;

import dao.VisitorDAO;
import dao.mapper.RowMapper;
import dao.transaction.SQLOperation;
import dao.transaction.TransactionHandler;
import db.DataSourceFactory;
import entities.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JdbcVisitorDAO implements VisitorDAO {
    private final DataSource dataSource;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private final RowMapper<Visitor> visitorRowMapper = (rs) -> {
        Visitor visitor = new Visitor();
        visitor.setID(rs.getLong("id"));
        visitor.setFirstName(rs.getString("first_name"));
        visitor.setLastName(rs.getString("last_name"));
        visitor.setBirthday(rs.getObject("birthday", LocalDate.class));
        visitor.setNumber(rs.getString("number"));

        logger.info("Map result set to: " + visitor);

        return visitor;
    };

    public JdbcVisitorDAO() {
        this.dataSource = DataSourceFactory.getDataSource();
    }

    @Override
    public Visitor save(final Visitor visitor) {
        Objects.requireNonNull(visitor);

        SQLOperation<Connection, Visitor> insertVisitor = (connection)-> {
            PreparedStatement statement = connection
                    .prepareStatement("insert into visitor(first_name, last_name, birthday, number) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, visitor.getFirstName());
            statement.setString(2, visitor.getLastName());
            statement.setObject(3, visitor.getBirthday(), Types.TIMESTAMP);
            statement.setString(4, visitor.getNumber());

            int rowCount = statement.executeUpdate();
            if(rowCount > 0) {
                ResultSet key = statement.getGeneratedKeys();
                if(key.next()) {
                    visitor.setID(key.getLong(1));
                    logger.info("Persist " + visitor + "with ID: " + visitor.getID());
                }
            }

            statement.close();
            return visitor;
        };

        try {
            return TransactionHandler.doInTransaction(dataSource, insertVisitor);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Visitor entity) {

    }

    @Override
    public Visitor update(Visitor entity) {
        return null;
    }

    @Override
    public Optional<Visitor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Visitor> findAll() {
        return null;
    }

    @Override
    public Optional<Visitor> findByNumber(String number) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select * from visitor where number = ? limit 1")) {
            statement.setString(1, number);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                Visitor visitor = visitorRowMapper.mapToObject(rs);
                logger.info("Find "  + visitor);
                return Optional.of(visitor);
            }
        }
        catch (SQLException e) {

        }

        return Optional.empty();
    }
}
