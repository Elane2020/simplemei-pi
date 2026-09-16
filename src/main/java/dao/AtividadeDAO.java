package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Atividade;
import model.Imposto;

/**
 * Classe que fornece a lista de atividades permitidas ao MEI (Anexo XI),
 * constantes na tabela "atividades" do banco de dados.
 * A listagem é atualizada diretamente na tabela do banco.
 *
 * @author Elane
 */
public class AtividadeDAO {

    // R do CRUD
    public static List<Atividade> carregaCNAEs() {

        List<Atividade> listagem = new ArrayList<>();
        ConexaoJDBC conexao = new ConexaoJDBC();

        try {
            conexao.conectar();

            String sql = "SELECT cnae, ocupacao, desc_cnae, tipo_imposto FROM atividades ORDER BY ocupacao;";

            PreparedStatement consulta = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                Atividade a = new Atividade(
                        resultado.getString("cnae"),
                        resultado.getString("ocupacao"),
                        resultado.getString("desc_cnae"),
                        Imposto.valueOf(resultado.getString("tipo_imposto"))
                );
                listagem.add(a);
            }

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar as atividades no banco de dados: " + se.getMessage(),
                    "Atenção", JOptionPane.WARNING_MESSAGE);

        } finally {
            try {
                if (conexao.getConexao() != null && !conexao.getConexao().isClosed()) {
                    conexao.getConexao().close();
                }
            } catch (SQLException ignorada) {

            }
        }
        return listagem;
    }

    public static Atividade listaOcupacao(String ocupacao) {

        if (ocupacao == null) {
            return null;
        }
        for (Atividade atividade : carregaCNAEs()) {
            if (atividade.getOcupacao().equalsIgnoreCase(ocupacao.trim())) {
                return atividade;
            }
        }
        return null;
    }
    
    public static Atividade listaCnae(String cnae) {

    if (cnae == null) {
        return null;
    }
    for (Atividade atividade : carregaCNAEs()) {
        if (atividade.getCnae().equalsIgnoreCase(cnae.trim())) {
            return atividade;
        }
    }
    return null;
}
    
}