package Supermercado.dao;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionBlock<T> {

	T executeWith(Connection connection) throws SQLException;

}
