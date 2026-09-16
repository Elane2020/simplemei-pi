package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Lancamento;
import model.Movimento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Classe responsável pelo CRUD de lançamentos no banco de dados.
 * 
 * @author Elane
 */
public class LancamentoDAO {

    // C do CRUD
    public static boolean adicionar(Lancamento l) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "INSERT INTO lancamentos (tipo, data_operacao, data_vencimento, setor, contas, "
                    + "descricao, valor_orig, cliente_fornecedor, status_pagamento, data_liquidacao, formas, "
                    + "valor_liquidado, juros, desconto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql, 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            consulta.setString(1, l.getTipo().name());
            consulta.setString(2, converterParaSQL(l.getDataOperacao()));
            consulta.setString(3, converterParaSQL(l.getDataVencimento()));
            consulta.setString(4, l.getSetor());
            consulta.setString(5, l.getContas());
            consulta.setString(6, l.getDescricao());
            consulta.setDouble(7, l.getValorOrig());
            consulta.setString(8, l.getClienteFornecedor());
            consulta.setString(9, l.getStatus());
            consulta.setString(10, converterParaSQL(l.getDataLiquidacao()));
            consulta.setString(11, l.getFormas());
            consulta.setDouble(12, l.getValorLiquidado());
            consulta.setDouble(13, l.getJuros());
            consulta.setDouble(14, l.getDesconto());

            consulta.execute();
            
            ResultSet rs = consulta.getGeneratedKeys();
                if (rs.next()) {
                l.setId(rs.getInt(1));
               
            }

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o lançamento no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
           conexao.desconectar();
        }
    }
    
      // R do CRUD
    public static ArrayList<Lancamento> listar() {

        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT * FROM lancamentos ORDER BY data_operacao;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Lancamento l = new Lancamento(
                        resultado.getInt("id"),
                        Movimento.valueOf(resultado.getString("tipo")),
                        converterParaJAVA(resultado.getString("data_operacao")),
                        converterParaJAVA(resultado.getString("data_vencimento")),
                        resultado.getString("setor"),
                        resultado.getString("contas"),
                        resultado.getString("descricao"),
                        resultado.getDouble("valor_orig"),
                        resultado.getString("cliente_fornecedor"),
                        resultado.getString("status_pagamento"),
                        converterParaJAVA(resultado.getString("data_liquidacao")),
                        resultado.getString("formas"),
                        resultado.getDouble("valor_liquidado"),
                        resultado.getDouble("juros"),
                        resultado.getDouble("desconto")
                );
                lancamentos.add(l);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao listar os lançamentos no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
           conexao.desconectar();
           
        }
        return lancamentos;
    }
    
    // U do CRUD
    public static boolean editar(Lancamento l) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "UPDATE lancamentos SET tipo = ?, data_operacao = ?, data_vencimento = ?, setor = ?, "
                    + "contas = ?, descricao = ?, valor_orig = ?, cliente_fornecedor = ?, status_pagamento = ?, "
                    + "data_liquidacao = ?, formas = ?, valor_liquidado = ?, juros = ?, desconto = ? "
                    + "WHERE id = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);

            consulta.setString(1, l.getTipo().name());
            consulta.setString(2, converterParaSQL(l.getDataOperacao()));
            consulta.setString(3, converterParaSQL(l.getDataVencimento()));
            consulta.setString(4, l.getSetor());
            consulta.setString(5, l.getContas());
            consulta.setString(6, l.getDescricao());
            consulta.setDouble(7, l.getValorOrig());
            consulta.setString(8, l.getClienteFornecedor());
            consulta.setString(9, l.getStatus());
            consulta.setString(10, converterParaSQL(l.getDataLiquidacao()));
            consulta.setString(11, l.getFormas());
            consulta.setDouble(12, l.getValorLiquidado());
            consulta.setDouble(13, l.getJuros());
            consulta.setDouble(14, l.getDesconto());
            consulta.setInt(15, l.getId());

            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao atualizar o lançamento no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }

        // D do CRUD
public static boolean excluir(Lancamento l) {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "DELETE FROM lancamentos WHERE id = ?;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            
            consulta.setInt(1, l.getId());
            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao excluir o lançamento no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }

 // restaurando um backup salvo na pasta
    public static boolean limparRegistro() {

        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "DELETE FROM lancamentos;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            consulta.execute();

            return true;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao limpar os lançamentos no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return false;

        } finally {
            conexao.desconectar();
        }
    }
    
    // lê o arquivo de backup .csv e importa os lançamentos
     public static int restaurar(File arquivoCSV) {

        int totalRestaurado = 0;

        try (BufferedReader leitor = new BufferedReader(
                new InputStreamReader(new FileInputStream(arquivoCSV), StandardCharsets.ISO_8859_1))) {

            String linha = leitor.readLine();

            while ((linha = leitor.readLine()) != null) {

                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] campos = linha.split(";", -1);

                if (campos.length < 14) {
                    continue; 
                }

                Movimento tipo = parseMovimento(campos[0]);

                if (tipo == null) {
                    continue; 
                }

                Lancamento l = new Lancamento(
                        tipo,
                        campos[1],
                        campos[2],
                        campos[3],
                        campos[4],
                        campos[5],
                        parseValor(campos[6]),
                        campos[7],
                        campos[8],
                        campos[9],
                        campos[10],
                        parseValor(campos[11]),
                        parseValor(campos[12]),
                        parseValor(campos[13])
                );

                if (adicionar(l)) {
                    totalRestaurado++;
                }
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de backup: " + e.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

            return -1;
        }

        return totalRestaurado;
    }

    
    private static Movimento parseMovimento(String texto) {

        if (texto == null) {
            return null;
        }

        switch (texto.trim()) {
            case "Receita":
                return Movimento.RECEITA;
            case "Despesa":
                return Movimento.DESPESA;
            case "Compra":
                return Movimento.COMPRAS;
            case "Custo":
                return Movimento.CUSTOS;
            default:
                return null;
        }
    }


    private static double parseValor(String valor) {
       
        if (valor == null || valor.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(valor.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return 0.0;
        }
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