package dao.transaction;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface SQLOperation<T extends Connection,V> {
    V apply(T connection) throws SQLException;
}
