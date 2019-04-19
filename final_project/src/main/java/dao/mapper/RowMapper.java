package dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<T> {
    T mapToObject(ResultSet rs) throws SQLException;
}
