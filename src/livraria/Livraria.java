package livraria;

import DB.Connect;
import java.sql.Connection;

public class Livraria {

    public static void main(String[] args) {
        Connection teste = new Connect("livraria").connection;
    }
    
}
