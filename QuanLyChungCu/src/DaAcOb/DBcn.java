package DaAcOb;
import java.sql.*;
public class DBcn {
    private static Connection conn;
    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Thay đổi URL, USERNAME và PASSWORD phù hợp với cấu hình 
                String URL = "jdbc:mysql://127.0.0.1:3306/bluemoon";
                String USERNAME = "root";
                String PASSWORD = "";

                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return conn;
    }
}
