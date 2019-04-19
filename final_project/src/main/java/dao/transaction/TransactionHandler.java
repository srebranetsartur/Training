package dao.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TransactionHandler {
    public static <T> T doInTransaction(DataSource dataSource, SQLOperation<Connection, T> f) throws SQLException {
        Connection connection = null;
        T returnValue;
        boolean initialAutocommit = false;
        try {
            connection = dataSource.getConnection();
            initialAutocommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            returnValue = f.apply(connection);
            connection.commit();
            return returnValue;
        } catch (Throwable throwable) {
            if (connection != null) {
                connection.rollback();
            }
            throw throwable;
        } finally {
            if (connection != null) {
                try {
                    if (initialAutocommit) {
                        connection.setAutoCommit(true);
                    }
                    connection.close();
                } catch (Throwable e) {
                    // Use your own logger here. And again, maybe not catch throwable,
                    // but then again, you should never throw from a finally ;)
                }
            }
        }
    }
}
