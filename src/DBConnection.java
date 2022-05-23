import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException, Exception {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "";
        final String DB_URL = "";

        //  Database credentials
        final String USER = "root";
        final String PASS = "";

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }
}
