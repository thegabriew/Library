package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import helpers.AnsiScape;
import helpers.Println;

public class Connect {

    public static Connection connection = null;

    private String userName = null;
    private String userPassword = null;
    private String databaseName = null;

    private String timeZoneString = "&useTimezone=true&serverTimezone=UTC";
    private String baseURL = "jdbc:mysql://localhost:3306/";

    public Connect(String usuario, String senha, String nomeDoBanco) {
        this.databaseName = nomeDoBanco;
        this.userName = usuario;
        this.userPassword = senha;

        try {
            this.createConnection("");
            if (connection != null) {
                Println.colored(LoadDriver.message, AnsiScape.ANSI_BLUE);
                if (createDatabase(this.databaseName)) {
                    Println.colored("Conectado com sucesso ao banco " + this.databaseName, AnsiScape.ANSI_BLUE);
                } else {
                    Println.colored("Falha ao conectar ao banco " + this.databaseName, AnsiScape.ANSI_RED);
                }
            }
        } catch (SQLException ex) {
            connection = null;
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    private void createConnection(String DatabaseName) throws SQLException {
        if (LoadDriver.load()) {

            connection = DriverManager.getConnection(
                    this.baseURL
                    + DatabaseName
                    + "?user=" + this.userName
                    + "&password=" + this.userPassword
                    + this.timeZoneString);
        } else {
            Println.colored(LoadDriver.message, AnsiScape.ANSI_RED);
        }

    }

    private boolean createDatabase(String nomeDoBanco) throws SQLException {
        CreateDB banco = new CreateDB(connection, nomeDoBanco);
        this.createConnection(nomeDoBanco);

        return banco.DbIsCreated();
    }
}
