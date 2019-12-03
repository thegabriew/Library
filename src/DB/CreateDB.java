package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    private boolean DbCreated = false;

    public CreateDB(Connection c, String nomeDoBanco) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + nomeDoBanco ;
        Statement stmt = c.createStatement();
        stmt.executeUpdate(sql);
        this.setDbCreated(true);
    }

    public boolean DbIsCreated() {
        return DbCreated;
    }

    public void setDbCreated(boolean DbCreated) {
        this.DbCreated = DbCreated;
    }

}
