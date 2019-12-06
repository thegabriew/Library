package livraria;

import DB.Connect;
import DB.CreateDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Livraria {

    public static void main(String[] args) {
        Connection testeConexao = new Connect("root","","Livraria").connection;
    }
    
}
