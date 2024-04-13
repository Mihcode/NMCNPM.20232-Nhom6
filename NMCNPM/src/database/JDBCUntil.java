package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JDBCUntil {
    public static Connection getConnection() {
        Connection c = null;

        try {
            // Load the SQL Server driver (not needed to register explicitly)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Connection parameters
            String url = "jdbc:sqlserver://DESKTOP-KT3KI6S:1433;encrypt=true;databaseName=Quanlychungcu;trustServerCertificate = true";
            String userName = "sa";
            String password = "admin";

            c = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
    public static void main(String[] args) {
    	Connection connection = JDBCUntil.getConnection();
		System.out.println(connection);
	}
}
