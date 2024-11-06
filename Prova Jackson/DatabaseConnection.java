import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Escola"; //lembrar de alterar o schema
    private static final String USER = "root";
    private static final String PASSWORD = ""; //conexão simples

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    } //registra driver, não funciona sem!! NAÕ SEI PQ, NÃO QUERO SABER O PQ, E TO COM ODIO DISSO NO MOMENTO!

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
} //metodo para obeter conexão. Importante não mexer
