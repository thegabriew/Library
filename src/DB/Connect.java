package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static Connection connection = null;

    public Connect(String nomeDoBanco) {
        if (LoadDriver.load()) {
            try {
                
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"
                        + nomeDoBanco + "?user=root&password="
                        + "&useTimezone=true&serverTimezone=UTC");
                
                System.err.println(connection);
                
            } catch (SQLException ex) {
                if (connection == null) {
                    
                    connection = new Connect("").connection;
                    System.err.println(connection);
                    
                    try {
                        CreateDB banco = new CreateDB(connection, nomeDoBanco);
                        connection = new Connect(nomeDoBanco).connection;
                    } catch (SQLException ex1) {
                        System.err.println("SQLException: " + ex.getMessage());
                        System.err.println("SQLState: " + ex.getSQLState());
                        System.err.println("VendorError: " + ex.getErrorCode());
                    }

                }
            }

        }
    }
}
