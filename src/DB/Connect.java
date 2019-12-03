package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connection = null;

    public Connect(String nomeDoBanco) {
        if (LoadDriver.load()) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"
                         + nomeDoBanco + "?user=root&password="
                         + "&useTimezone=true&serverTimezone=UTC");
            } catch (SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
            }
        }
    }
}
