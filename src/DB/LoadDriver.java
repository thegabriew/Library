package DB;

public class LoadDriver {

    public static boolean load() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
                    .newInstance();
            System.out.println("JDBC carregado");
            return true;
        } catch (Exception erro) {
            System.err.println("JDBC não encontrado");
            System.err.println(erro);
            return false;
        }
    }
}
