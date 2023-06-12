package aplication;

import conexaoMysql.ConexaoBD;
import entidade.UsuarioDAO;

import java.sql.Connection;


public class App {

    public static void main(String[] args) {

        ConexaoBD conexaoBD = new ConexaoBD();
        conexaoBD.conectar();


        UsuarioDAO usuarioDAO = new UsuarioDAO(); // Alterei para usar a classe UsuarioDAO
        Connection connection = conexaoBD.getConnection(); // Obtém a instância de Connection

        // Chama o método CadastrarUsuario passando a conexão e os dados do usuário
        UsuarioDAO.CadastrarUsuario(connection, "525709-9", "Daniel", "123456", "illaap@hotmail.com", 1, "cabo", "P4", "JP");

        // Use a conexão para executar operações no banco de dados

        conexaoBD.desconectar();

    }
}
