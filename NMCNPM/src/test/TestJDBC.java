package test;

import java.sql.Connection;

import database.JDBCUntil;

public class TestJDBC {
	public static void main(String[] args) {
		Connection connection = JDBCUntil.getConnection();
		System.out.println(connection);
	}
}
