package conexaoMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    public ConexaoBD() {
        this.url = "jdbc:mysql://bdrpmontp42022.mysql.uhserver.com/bdrpmontp42022";
        this.username = "willames";
        this.password = "rpmont.2022.p4.";
    }

    public void conectar() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexão estabelecida com o banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

