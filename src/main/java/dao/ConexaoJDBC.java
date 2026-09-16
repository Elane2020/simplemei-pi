package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Gerencia a conexão com o banco de dados (MySQL) "simplemei", 
 * utilizada pelas classes DAO do sistema.
 * 
 * @author Elane
*/
public class ConexaoJDBC {

    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/simplemei", "root", "320185");
          //    JOptionPane.showMessageDialog(null, "Conexão bem-sucedida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Falha ao carregar a classe de conexão, classe não encontrada!\n" + cnfe,
                    "Erro de Driver", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco! Erro de SQL:\n" + se, "Erro de SQL",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            //    JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");

            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar");
        }

    }

}