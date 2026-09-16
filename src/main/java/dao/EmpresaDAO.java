package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Endereco;
import model.Atividade;

/**
 * Classe responsável pelo CRUD da empresa (MEI dono do sistema). 
 * 
 * @author Elane
 */
public class EmpresaDAO {

    // C do CRUD
    public static boolean adicionar(Empresa e) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

           String sql = "INSERT INTO empresa (razao_social, num_cnpj, data_abertura, num_ie, num_im, "
                    + "responsavel, cpf, telefone, email, ano, "
                    + "resid_logradouro, resid_bairro, resid_cidade, resid_complemento, resid_estado, resid_cep,"
                    + "com_logradouro, com_bairro, com_cidade, com_complemento, com_estado, com_cep) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";


            Endereco residencial = e.getEndereco();
            Endereco comercial = e.getEnderecoComercial();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, e.getRazaoSocial());
            consulta.setString(2, e.getNumCNPJ());
            consulta.setString(3, converterParaSQL(e.getDataAbertura()));            
            consulta.setString(4, e.getNumIE());
            consulta.setString(5, e.getNumIM());
            
            consulta.setString(6, e.getResponsavel());
            consulta.setString(7, e.getCpf());
            consulta.setString(8, e.getTelefone());
            consulta.setString(9, e.getEmail());
            consulta.setString(10, e.getAno());
           
            consulta.setString(11, residencial != null ? residencial.getLogradouro() : null);
            consulta.setString(12, residencial != null ? residencial.getBairro() : null);
            consulta.setString(13, residencial != null ? residencial.getCidade() : null);
            consulta.setString(14, residencial != null ? residencial.getComplemento(): null);
            consulta.setString(15, residencial != null ? residencial.getEstado() : null);
            consulta.setString(16, residencial != null ? residencial.getCep() : null);
            
            consulta.setString(17, comercial != null ? comercial.getLogradouro() : null);
            consulta.setString(18, comercial != null ? comercial.getBairro() : null);
            consulta.setString(19, comercial != null ? comercial.getCidade() : null);
            consulta.setString(20, comercial != null ? comercial.getComplemento() : null);
            consulta.setString(21, comercial != null ? comercial.getEstado() : null);
            consulta.setString(22, comercial != null ? comercial.getCep() : null);
            
            consulta.execute();              
            

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a empresa no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }

    // R do CRUD 
    public static Empresa obter() {

        Empresa empresa = null;
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM empresa ORDER BY id LIMIT 1;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {

                Endereco enderecoResidencial = new Endereco(
                        resultado.getString("resid_logradouro"),
                        resultado.getString("resid_bairro"),
                        resultado.getString("resid_cidade"), 
                        resultado.getString("resid_complemento"),
                        resultado.getString("resid_estado"),
                        resultado.getString("resid_cep")
                        
                        
                );

                empresa = new Empresa(
                        resultado.getString("razao_social"),
                        resultado.getString("num_cnpj"),
                        converterParaJAVA(resultado.getString("data_abertura")),
                        resultado.getString("num_ie"),
                        resultado.getString("num_im"),
                        enderecoResidencial,
                        resultado.getString("responsavel"),                        
                        resultado.getString("cpf"),                        
                        resultado.getString("telefone"),
                        resultado.getString("email")
                       
                );

                empresa.setAno(resultado.getString("ano"));
                

                Endereco enderecoComercial = new Endereco(
                        resultado.getString("com_logradouro"),
                        resultado.getString("com_bairro"),
                        resultado.getString("com_cidade"),
                        resultado.getString("com_complemento"),
                        resultado.getString("com_estado"),
                        resultado.getString("com_cep")
                );
                empresa.setEnderecoComercial(enderecoComercial);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao obter os dados da empresa no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
        }
        return empresa;
    }

    // U do CRUD
    public static boolean atualizar(Empresa e) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "UPDATE empresa SET razao_social = ?, num_cnpj = ?, data_abertura = ?, num_ie = ?, num_im = ?, "
                    + "responsavel = ?, cpf = ?, telefone = ?, email = ?, ano = ?,  "
                    + "resid_logradouro = ?, resid_bairro = ?, resid_cidade = ?, resid_complemento = ?,"
                    + " resid_estado = ?, resid_cep = ?, "
                    + "com_logradouro = ?, com_bairro = ?, com_cidade = ?, com_complemento = ?, "
                    + "com_estado = ?, com_cep = ? "
                    + "ORDER BY id LIMIT 1;";

            Endereco residencial = e.getEndereco();
            Endereco comercial = e.getEnderecoComercial();

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setString(1, e.getRazaoSocial());
            consulta.setString(2, e.getNumCNPJ());
            consulta.setString(3, converterParaSQL(e.getDataAbertura()));
            consulta.setString(4, e.getNumIE());
            consulta.setString(5, e.getNumIM());
            consulta.setString(6, e.getResponsavel());
            consulta.setString(7, e.getCpf());
            consulta.setString(8, e.getTelefone());
            consulta.setString(9, e.getEmail());
            consulta.setString(10, e.getAno());

            consulta.setString(11, residencial != null ? residencial.getLogradouro() : null);
            consulta.setString(12, residencial != null ? residencial.getBairro() : null);
            consulta.setString(13, residencial != null ? residencial.getCidade() : null);
            consulta.setString(14, residencial != null ? residencial.getComplemento() : null);
            consulta.setString(15, residencial != null ? residencial.getEstado() : null);
            consulta.setString(16, residencial != null ? residencial.getCep() : null);

            consulta.setString(17, comercial != null ? comercial.getLogradouro() : null);
            consulta.setString(18, comercial != null ? comercial.getBairro() : null);
            consulta.setString(19, comercial != null ? comercial.getCidade() : null);
            consulta.setString(20, comercial != null ? comercial.getComplemento() : null);
            consulta.setString(21, comercial != null ? comercial.getEstado() : null);
            consulta.setString(22, comercial != null ? comercial.getCep() : null);

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar a empresa no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }
     
  
public static boolean salvarAtividade(Atividade a) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();
            
            //por enquanto, salva apenas a atividade principal.
            PreparedStatement limpar = conexao.getConexao().prepareStatement(
                "DELETE FROM empresa_atividades "
                + "WHERE id_empresa = (SELECT id FROM empresa ORDER BY id LIMIT 1);"
            );
            limpar.execute();

            if (a == null || a.getCnae() == null || a.getCnae().trim().isEmpty()) {
                return true;
            }

            PreparedStatement inserir = conexao.getConexao().prepareStatement(
                "INSERT INTO empresa_atividades (id_empresa, cnae) "
                + "VALUES ((SELECT id FROM empresa ORDER BY id LIMIT 1), ?);"
            );

            inserir.setString(1, a.getCnae());
            inserir.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(
                null,
                "Erro ao salvar a atividade da empresa: " + se.getMessage(),
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            return false;

        } finally {
            conexao.desconectar();
        }
    }

    public static String obterAtividade (){

        ConexaoJDBC conexao = new ConexaoJDBC();
        String cnae = null;

        try {
            conexao.conectar();

            String sql = "SELECT ea.cnae FROM empresa_atividades ea "
                    + "JOIN empresa e ON e.id = ea.id_empresa "
                    + "ORDER BY e.id LIMIT 1;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
                cnae = resultado.getString("cnae");
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao obter a atividade da empresa: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
        }

        return cnae;
    }


public static String converterParaSQL(String dataAntiga) {

        if (dataAntiga == null || dataAntiga.trim().isEmpty()) {
            return null;
        }

        String[] partesData = dataAntiga.split("/");
        String dataNova = partesData[2] + "-" + partesData[1] + "-" + partesData[0];
        return dataNova;

    }

    public static String converterParaJAVA(String dataAntiga) {

        if (dataAntiga == null || dataAntiga.trim().isEmpty()) {
            return "";
        }

        String[] partesData = dataAntiga.split("-");
        String dataNova = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
        return dataNova;

    }
}