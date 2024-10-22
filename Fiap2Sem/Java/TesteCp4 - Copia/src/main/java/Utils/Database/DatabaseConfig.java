package Utils.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/ORCL";  // Usando "/"
    private static String USER = "rm556772";
    private static String PASSWORD = "051205";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

