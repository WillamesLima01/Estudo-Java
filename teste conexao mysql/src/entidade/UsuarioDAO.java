package entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public static void CadastrarUsuario(Connection connection, String matricula, String nome, String senha, String email, int nivel, String postgrad, String setor, String cidade) {
        try {
            String sql = "INSERT INTO TBusurio (matricula, nome, senha, email, nivel, postgrad, setor, cidade ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, matricula);
            statement.setString(2, nome);
            statement.setString(3, senha);
            statement.setString(4, email);
            statement.setString(5, String.valueOf(nivel));
            statement.setString(6, postgrad);
            statement.setString(7, setor);
            statement.setString(8, cidade);

            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário cadastrado com sucesso.");
            } else {
                System.out.println("Falha ao cadastrar usuário.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}