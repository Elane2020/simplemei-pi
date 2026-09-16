package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Endereco;

/**
 * Classe responsável pelo CRUD de clientes no banco de dados.
 * 
 * @author Elane
 */
public class ClienteDAO {

    // C do CRUD
    public static boolean adicionar(Cliente c) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "INSERT INTO clientes (tipo_cliente, nome_cliente, num_cnpj, num_ie, "
                    + " logradouro, bairro, cep, cidade, estado, telefone, email, responsavel "
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

            Endereco end = c.getEndereco();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, c.getTipoCliente());
            consulta.setString(2, c.getNomeCliente());
            consulta.setString(3, c.getNumCNPJ());
            consulta.setString(4, c.getNumIE());
            consulta.setString(5, end != null ? end.getLogradouro() : null);
            consulta.setString(6, end != null ? end.getBairro() : null);
            consulta.setString(7, end != null ? end.getCep() : null);
            consulta.setString(8, end != null ? end.getCidade() : null);
            consulta.setString(9, end != null ? end.getEstado() : null);
            consulta.setString(10, c.getTelefone());
            consulta.setString(11, c.getEmail());
            consulta.setString(12, c.getResponsavel());
           

            consulta.execute();
            
            System.out.println("DEBUG - responsavel a ser salvo: [" + c.getResponsavel() + "]");
            
            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();

         
        }
    }
    
    // R do CRUD
    public static ArrayList<Cliente> listar() {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM clientes ORDER BY nome_cliente;";

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

                Cliente c = new Cliente();
                c.setNomeCliente(resultado.getString("nome_cliente"));
                c.setTipoCliente(resultado.getString("tipo_cliente"));
                c.setNumCNPJ(resultado.getString("num_cnpj"));
                c.setNumIE(resultado.getString("num_ie"));
                c.setEndereco(end);
                c.setEmail(resultado.getString("email"));
                c.setTelefone(resultado.getString("telefone"));
                c.setResponsavel(resultado.getString("responsavel"));
                c.setIdCliente(resultado.getInt("id_cliente"));

                clientes.add(c);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao listar os clientes no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
            
        }
        return clientes;
    }

    // U do CRUD
public static boolean atualizar(Cliente c) {

    ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "UPDATE clientes SET tipo_cliente = ?, nome_cliente = ?,  num_cnpj = ?, num_ie = ?, "
                    + " logradouro = ?, bairro = ?, cep = ?, cidade = ?, estado = ?, "
                    + " telefone = ?, email = ?,responsavel = ? "
                    + "WHERE id_cliente = ?;";

            Endereco end = c.getEndereco();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, c.getTipoCliente());
            consulta.setString(2, c.getNomeCliente());
            consulta.setString(3, c.getNumCNPJ());
            consulta.setString(4, c.getNumIE());
            consulta.setString(5, end != null ? end.getLogradouro() : null);
            consulta.setString(6, end != null ? end.getBairro() : null);
            consulta.setString(7, end != null ? end.getCep() : null);
            consulta.setString(8, end != null ? end.getCidade() : null);
            consulta.setString(9, end != null ? end.getEstado() : null);
            consulta.setString(10, c.getTelefone());
            consulta.setString(11, c.getEmail());
            consulta.setString(12, c.getResponsavel());
            consulta.setInt(13, c.getIdCliente());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar o cliente no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            
            conexao.desconectar();
            
        }
    }
    
    // D do CRUD
    public static boolean excluir(Cliente c) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "DELETE FROM clientes WHERE id_cliente = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.setInt(1, c.getIdCliente());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
             conexao.desconectar();
        }
    }

    
}