package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Fornecedor;

/**
 * Classe responsável pelo CRUD de fornecedores no banco de dados.
 * 
 * @author Elane
 */

public class FornecedorDAO {

    // C do CRUD
    public static boolean adicionar(Fornecedor f) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "INSERT INTO fornecedores (tipo_fornecedor, razao_social, num_cnpj, num_ie, "
                + "logradouro, bairro, cep, cidade, estado, telefone,email, responsavel "
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";


            Endereco end = f.getEndereco();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, f.getTipoFornecedor());
            consulta.setString(2, f.getRazaoSocial());
            consulta.setString(3, f.getNumCNPJ());
            consulta.setString(4, f.getNumIE());
            consulta.setString(5, end != null ? end.getLogradouro() : null);
            consulta.setString(6, end != null ? end.getBairro() : null);
            consulta.setString(7, end != null ? end.getCep() : null);
            consulta.setString(8, end != null ? end.getCidade() : null);
            consulta.setString(9, end != null ? end.getEstado() : null);
            consulta.setString(10, f.getTelefone());
            consulta.setString(11, f.getEmail());
            consulta.setString(12, f.getResponsavel());
            
           
            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o fornecedor no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }
    
     // R do CRUD
    public static ArrayList<Fornecedor> listar() {

        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM fornecedores ORDER BY razao_social;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Endereco end = new Endereco();
                end.setLogradouro(resultado.getString("logradouro"));
                end.setBairro(resultado.getString("bairro"));
                end.setCidade(resultado.getString("cidade"));
                end.setComplemento(null);
                end.setEstado(resultado.getString("estado"));
                end.setCep(resultado.getString("cep"));

                Fornecedor f = new Fornecedor();
                f.setRazaoSocial(resultado.getString("razao_social"));
                f.setTipoFornecedor(resultado.getString("tipo_fornecedor"));
                f.setNumCNPJ(resultado.getString("num_cnpj"));
                f.setNumIE(resultado.getString("num_ie"));
                f.setEndereco(end);
                f.setEmail(resultado.getString("email"));
                f.setTelefone(resultado.getString("telefone"));
                f.setResponsavel(resultado.getString("responsavel"));
                f.setIdFornecedor(resultado.getInt("id_fornecedor"));

                fornecedores.add(f);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao listar os fornecedores no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
        }
        return fornecedores;
    }
    
    // U do CRUD
       
public static boolean atualizar(Fornecedor f) {

    ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "UPDATE fornecedores SET tipo_fornecedor = ?, razao_social = ?, num_cnpj = ?, num_ie = ?, "
                    + "logradouro = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, telefone = ?, "
                    + "email = ?, responsavel = ? "
                    + "WHERE id_fornecedor = ?;";

            Endereco end = f.getEndereco();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, f.getTipoFornecedor());
            consulta.setString(2, f.getRazaoSocial());
            consulta.setString(3, f.getNumCNPJ());
            consulta.setString(4, f.getNumIE());
            consulta.setString(5, end != null ? end.getLogradouro() : null);
            consulta.setString(6, end != null ? end.getBairro() : null);
            consulta.setString(7, end != null ? end.getCep() : null);
            consulta.setString(8, end != null ? end.getCidade() : null);
            consulta.setString(9, end != null ? end.getEstado() : null);
            consulta.setString(10, f.getTelefone());
            consulta.setString(11, f.getEmail());
            consulta.setString(12, f.getResponsavel());
            consulta.setInt(13, f.getIdFornecedor());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar o fornecedor no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            
            conexao.desconectar();
            
        }
    }
    

    // D do CRUD
    public static boolean excluir(Fornecedor f) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "DELETE FROM fornecedores WHERE id_fornecedor = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, f.getIdFornecedor());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir o fornecedor no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
            
        }
    }

   
}