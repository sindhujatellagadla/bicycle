package com.manufacture.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manufacture.exception.connectionUtitlityException;

public class ConnectionUtility {
	Connection con = null;
	public static final String URL = "jdbc:mysql://localhost:3306/bicycle";
	public static final String USER = "root";
	public static final String PASSWORD = "12345";

	public Connection getMyConnection() throws connectionUtitlityException {

		Connection con;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			return con;
		} catch (SQLException e) {
			throw new connectionUtitlityException("connection failed", e);
		}
	}

	public void closeResource(Connection con) throws connectionUtitlityException {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new connectionUtitlityException();
			}
		}
	}
	public void closeResource(PreparedStatement ps) throws connectionUtitlityException {
		if (con != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new connectionUtitlityException();
			}
		}
	}
	public void closeResource(ResultSet rs) throws connectionUtitlityException {
		if (con != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new connectionUtitlityException();
			}
		}
	}
}

