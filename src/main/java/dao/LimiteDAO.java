package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Limite;

/**
 * Classe que fornece o limite de faturamento do MEI por ano (tabela
 * "limites_mei"). Se o valor mudar, atualiza-se a tabela diretamente no banco de dados.
 * 
 * @author Elane
 */
public class LimiteDAO {

    // R do CRUD
    public static List<Limite> carregaLimites() {

        List<Limite> listagem = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT ano, limite_anual FROM limites_mei ORDER BY ano DESC;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Limite l = new Limite(
                        resultado.getString("ano"),
                        resultado.getDouble("limite_anual")
                );
                listagem.add(l);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar os limites do MEI: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            conexao.desconectar();
        }
        return listagem;
    }

    public static Limite obterLimite(String ano) {

        if (ano == null) {
            return null;
        }
        for (Limite limite : carregaLimites()) {
            if (limite.getAno().equals(ano.trim())) {
                return limite;
            }
        }
        return null;
    }
}