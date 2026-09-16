package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * Classe responsável pelo CRUD de usuários no banco de dados e 
 * validação de login.
 * 
 * @author Elane
 */
public class UsuarioDAO {

    // C do CRUD
    public static boolean adicionar(Usuario u) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "INSERT INTO usuarios (usuario, senha, tipo, email, primeiro_acesso) VALUES (?,?,?,?,?);";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, u.getUsuario());
            consulta.setString(2, u.getSenha());
            consulta.setString(3, u.getTipo());
            consulta.setString(4, u.getEmail());
            consulta.setBoolean(5, u.isPrimeiroAcesso());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
           conexao.desconectar();
            
        }
    }

    // R do CRUD
    public static List<Usuario> listar() {

        List<Usuario> usuarios = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT id, usuario, senha, tipo, email, primeiro_acesso FROM usuarios ORDER BY id;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Usuario u = new Usuario();
                u.setId(resultado.getInt("id"));
                u.setUsuario(resultado.getString("usuario"));
                u.setSenha(resultado.getString("senha"));
                u.setTipo(resultado.getString("tipo"));
                u.setEmail(resultado.getString("email"));
                u.setPrimeiroAcesso(resultado.getBoolean("primeiro_acesso"));
                usuarios.add(u);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao listar os usuários no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
           
        }
        return usuarios;
    }

    
    // U do CRUD
    public static boolean atualizar(Usuario u) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "UPDATE usuarios SET usuario = ?, senha = ?, tipo = ?, email = ? WHERE id = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, u.getUsuario());
            consulta.setString(2, u.getSenha());
            consulta.setString(3, u.getTipo());
            consulta.setString(4, u.getEmail());
            consulta.setInt(5, u.getId());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar o usuário no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
            
        }
    }

    // D do CRUD
    public static boolean excluir(Usuario u) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "DELETE FROM usuarios WHERE id = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, u.getId());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
          
        }
    }

   
    public static List<Usuario> listarTodos() {
        return listar();
    }

    /**
     * Verifica as credenciais do usuario informados na tela de login.
     */
    
    public Usuario autenticar(String usuarioDigitado, String senhaDigitada) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT id, usuario, senha, tipo, email, primeiro_acesso "
                    + "FROM usuarios WHERE usuario = ? AND senha = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setString(1, usuarioDigitado);
            consulta.setString(2, senhaDigitada);

            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                Usuario u = new Usuario();
                u.setId(resultado.getInt("id"));
                u.setUsuario(resultado.getString("usuario"));
                u.setSenha(resultado.getString("senha"));
                u.setTipo(resultado.getString("tipo"));
                u.setEmail(resultado.getString("email"));
                u.setPrimeiroAcesso(resultado.getBoolean("primeiro_acesso"));
                return u;
            }

            return null;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao autenticar o usuário no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return null;

        } finally {
            try {
                if (conexao.getConexao() != null && !conexao.getConexao().isClosed()) {
                    conexao.getConexao().close();
                }
            } catch (SQLException ignorada) {

            }
        }
    }
}