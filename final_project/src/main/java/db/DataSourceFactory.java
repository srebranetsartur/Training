package db;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Produces connection pool
 */
public final class DataSourceFactory {
    private static volatile DataSource DATA_SOURCE = null;
    private static final String DB_CONFIG_FILE_NAME = "db_config.properties";

    private DataSourceFactory() {

    }

    public static DataSource getDataSource(){
        if(DATA_SOURCE == null) {
            synchronized (DataSourceFactory.class) {
                try {
                    Properties properties = new Properties();
                    properties.load(DataSourceFactory.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE_NAME));

                    String user = properties.getProperty("MYSQL_USER");
                    String password = properties.getProperty("MYSQL_PASSWORD");
                    String url = properties.getProperty("MYSQL_URL");

                    MysqlDataSource dataSource = new MysqlDataSource();
                    dataSource.setUser(user);
                    dataSource.setPassword(password);
                    dataSource.setUrl(url);

                    DATA_SOURCE = dataSource;
                }
                catch (IOException e) {

                }
            }
        }

        return DATA_SOURCE;
        }


}
