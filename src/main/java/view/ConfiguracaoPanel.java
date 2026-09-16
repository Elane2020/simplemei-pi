
package view;

import dao.AtividadeDAO;
import dao.EmpresaDAO;
import dao.LimiteDAO;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.swing.JOptionPane;
import model.Atividade;
import model.Empresa;
import model.Endereco;
import model.Imposto;
import model.Limite;
import model.Usuario;
import theme.Temas;

/**
 * Painel de configuração da empresa MEI (razão social, cnpj, atividade principal,
 * responsável, endereço, etc...).
 *
 * @author Elane
 */

public class ConfiguracaoPanel extends javax.swing.JPanel {

    private Empresa empresaMEI;
    private Usuario usuarioLogado;
    

    public ConfiguracaoPanel() {
        this(null);
    }
    
    public ConfiguracaoPanel(Usuario usuarioLogado) {
        initComponents();
        formatacaoVisual();
        formatoData(txtData);
        formatoCNPJ(txtCNPJ);
        formatoCPF(txtCPF);
        formatoFone(txtFone);
        formatoCEP(txtCEP);
        formatoCEP(txtCEPCom);
        txtLimAnual.setEnabled(false);
        txtLimMensal.setEnabled(false);
        txtLimCompras.setEnabled(false);
        
        this.usuarioLogado = usuarioLogado;
        
        carregarCNAE();
        carregarDados();
        
        
        geraAcessbilidade();
        Temas.addVersao(pnlInferior);
   
    } 

      private void carregarDados() {

        empresaMEI = EmpresaDAO.obter();

        if (empresaMEI != null) {
            preencherCampos();
            bloquearCampos(false);
            btnEditar.setEnabled(true);
            
        } else {
            limparCampos();
            bloquearCampos(true);
            btnEditar.setEnabled(false);
        }

        btnSalvar.setEnabled(empresaMEI == null);
        btnCancelar.setEnabled(true);
        
        if (usuarioLogado == null || !usuarioLogado.getTipo().equalsIgnoreCase("Gerente")) {
        
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        }    
        
        
    }

    private void preencherCampos() {

        txtNome.setText(empresaMEI.getRazaoSocial());
        txtCNPJ.setText(empresaMEI.getNumCNPJ());
        txtData.setText(empresaMEI.getDataAbertura());
        txtIE.setText(empresaMEI.getNumIE());
        txtIM.setText(empresaMEI.getNumIM());
        txtResponsavel.setText(empresaMEI.getResponsavel());
        txtCPF.setText(empresaMEI.getCpf());
        txtFone.setText(empresaMEI.getTelefone());
        txtEmail.setText(empresaMEI.getEmail());

        txtLogradouro.setText(empresaMEI.getEndereco().getLogradouro());
        txtBairro.setText(empresaMEI.getEndereco().getBairro());
        txtCidade.setText(empresaMEI.getEndereco().getCidade());
        cboxUF.setSelectedItem(empresaMEI.getEndereco().getEstado());
        txtCEP.setText(empresaMEI.getEndereco().getCep());
          
        txtLogradouroCom.setText(empresaMEI.getEnderecoComercial().getLogradouro());
        txtBairroCom.setText(empresaMEI.getEnderecoComercial().getBairro());
        txtCidadeCom.setText(empresaMEI.getEnderecoComercial().getCidade());
        cboxUFCom.setSelectedItem(empresaMEI.getEnderecoComercial().getEstado());
        txtCEPCom.setText(empresaMEI.getEnderecoComercial().getCep());
        
        cboxAno.setSelectedItem(empresaMEI.getAno());
        anoFaturamento();
        
        String cnaeSalvo = EmpresaDAO.obterAtividade();
        if (cnaeSalvo != null) {
        
        Atividade atividade = AtividadeDAO.listaCnae(cnaeSalvo);
        
        if (atividade != null) {
            cboxCNAE.setSelectedItem(atividade.getOcupacao());
            carregaImposto();
        }
    }
    
    }

    private void carregarCNAE() {
        
    List<Atividade> atividades = AtividadeDAO.carregaCNAEs();
    String[] ocupacoes = new String[atividades.size() + 1];

    ocupacoes[0] = "Selecione";
    for (int i = 0; i < atividades.size(); i++) {
        ocupacoes[i + 1] = atividades.get(i).getOcupacao();
    }

    cboxCNAE.setModel(new javax.swing.DefaultComboBoxModel<>(ocupacoes));

}
    
    private void carregaImposto() {
    
    String ocupacao = (String) cboxCNAE.getSelectedItem();
    Atividade atividade = AtividadeDAO.listaOcupacao(ocupacao);

    if (atividade != null) {
        Imposto imposto = atividade.getTipoImposto();
        txtTributo.setText(imposto.getDescricao());
        txtCodCNAE.setText(atividade.getCnae());
        
    } else {
        txtTributo.setText("");
        txtCodCNAE.setText("");
    }
}
        
    private void anoFaturamento () {

    String selecionado = (String) cboxAno.getSelectedItem();
    Limite limite = LimiteDAO.obterLimite(selecionado);

    if (limite != null) {
    txtLimAnual.setText(formatarValorCampo(limite.getLimiteAnual()));
    txtLimMensal.setText(formatarValorCampo(limite.getLimiteMensal()));
    txtLimCompras.setText(formatarValorCampo(limite.getLimiteCompras()));

    } else {
    txtLimAnual.setText("");
    txtLimMensal.setText("");
    txtLimCompras.setText("");
    
    }
}
    
    private void bloquearCampos(boolean ativaEdicao) {

        txtNome.setEnabled(ativaEdicao);
        txtCNPJ.setEnabled(ativaEdicao);
        txtIE.setEnabled(ativaEdicao);
        txtIM.setEnabled(ativaEdicao);
        txtData.setEnabled(ativaEdicao);
        
        txtResponsavel.setEnabled(ativaEdicao);
        txtCPF.setEnabled(ativaEdicao);
        txtFone.setEnabled(ativaEdicao);
        txtEmail.setEnabled(ativaEdicao);

        cboxAno.setEnabled(ativaEdicao);
        txtLimAnual.setEnabled(ativaEdicao);
        txtLimMensal.setEnabled(ativaEdicao);
        txtTributo.setEnabled(ativaEdicao);
        txtLimCompras.setEnabled(ativaEdicao);
        cboxCNAE.setEnabled(ativaEdicao);

        txtLogradouro.setEnabled(ativaEdicao);
        txtBairro.setEnabled(ativaEdicao);
        txtCidade.setEnabled(ativaEdicao);
        cboxUF.setEnabled(ativaEdicao);
        txtCEP.setEnabled(ativaEdicao);
        txtComplemento.setEnabled(ativaEdicao);
        chkboxEnd.setEnabled(ativaEdicao);

        txtLogradouroCom.setEnabled(ativaEdicao);
        txtBairroCom.setEnabled(ativaEdicao);
        txtCidadeCom.setEnabled(ativaEdicao);
        txtCompCom.setEnabled(ativaEdicao);
        cboxUFCom.setEnabled(ativaEdicao);
        txtCEPCom.setEnabled(ativaEdicao);
    }

        private void limparCampos() {

        txtNome.setText("");
        txtCNPJ.setText("");
        txtData.setText("");
        txtIE.setText("");
        txtIM.setText("");
        
        cboxCNAE.setSelectedIndex(0);
        txtCodCNAE.setText("");
        txtResponsavel.setText("");
        txtCPF.setText("");
        txtFone.setText("");
        txtEmail.setText("");
        cboxAno.setSelectedIndex(0);
        txtLogradouro.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtComplemento.setText("");
        cboxUF.setSelectedIndex(0);
        txtCEP.setText("");
        txtLogradouroCom.setText("");
        txtBairroCom.setText("");
        txtCidadeCom.setText("");
        txtCompCom.setText("");
        cboxUFCom.setSelectedIndex(0);
        txtCEPCom.setText("");
        chkboxEnd.setSelected(false);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbbEmpresa = new javax.swing.JTabbedPane();
        pnlEmpresa = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbCNPJ = new javax.swing.JLabel();
        lbIE = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        lbIM = new javax.swing.JLabel();
        txtIM = new javax.swing.JTextField();
        lbAbertura = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lbResponsavel = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        lbCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lbFone = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbSubResp = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        lbSubLim1 = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        cboxAno = new javax.swing.JComboBox<>();
        lbLimAnual = new javax.swing.JLabel();
        txtLimAnual = new javax.swing.JTextField();
        lbLimMensal = new javax.swing.JLabel();
        txtLimMensal = new javax.swing.JTextField();
        lbTipoTrib = new javax.swing.JLabel();
        lbLimCompras = new javax.swing.JLabel();
        txtLimCompras = new javax.swing.JTextField();
        lbCNAE = new javax.swing.JLabel();
        cboxCNAE = new javax.swing.JComboBox<>();
        txtCNPJ = new javax.swing.JFormattedTextField();
        txtTributo = new javax.swing.JTextField();
        txtCodCNAE = new javax.swing.JTextField();
        lbIE1 = new javax.swing.JLabel();
        pnlEndereco = new javax.swing.JPanel();
        lbEndereco = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        lbUF = new javax.swing.JLabel();
        cboxUF = new javax.swing.JComboBox<>();
        lbCEP = new javax.swing.JLabel();
        lbComplemento = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbSubEnd = new javax.swing.JLabel();
        chkboxEnd = new javax.swing.JCheckBox();
        lbEndCom = new javax.swing.JLabel();
        txtLogradouroCom = new javax.swing.JTextField();
        lbBairroCom = new javax.swing.JLabel();
        txtBairroCom = new javax.swing.JTextField();
        lbCidadeCom = new javax.swing.JLabel();
        txtCidadeCom = new javax.swing.JTextField();
        lbCompCom = new javax.swing.JLabel();
        txtCompCom = new javax.swing.JTextField();
        lbUFCom = new javax.swing.JLabel();
        cboxUFCom = new javax.swing.JComboBox<>();
        lbCEPCom = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        txtCEPCom = new javax.swing.JFormattedTextField();
        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(234, 239, 255));

        tbbEmpresa.setBackground(new java.awt.Color(255, 255, 255));

        pnlEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbNome.setForeground(new java.awt.Color(5, 4, 45));
        lbNome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNome.setText("Razão Social*");

        lbCNPJ.setForeground(new java.awt.Color(5, 4, 45));
        lbCNPJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCNPJ.setText("CNPJ*");

        lbIE.setForeground(new java.awt.Color(5, 4, 45));
        lbIE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIE.setText("Inscrição Estadual*");

        txtIE.setToolTipText("Escreva \"ISENTO\", se não possuir.");

        lbIM.setForeground(new java.awt.Color(5, 4, 45));
        lbIM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIM.setText("Inscrição Municipal");

        txtIM.setToolTipText("Escreva \"ISENTO\", se não possuir.");

        lbAbertura.setForeground(new java.awt.Color(5, 4, 45));
        lbAbertura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAbertura.setText("Data de Abertura*");

        lbResponsavel.setForeground(new java.awt.Color(5, 4, 45));
        lbResponsavel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbResponsavel.setText("Nome do Responsável*");

        lbCPF.setForeground(new java.awt.Color(5, 4, 45));
        lbCPF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCPF.setText("CPF*");

        lbFone.setForeground(new java.awt.Color(5, 4, 45));
        lbFone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFone.setText("Telefone*");

        lbEmail.setForeground(new java.awt.Color(5, 4, 45));
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmail.setText("E-mail*");

        lbSubResp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSubResp.setForeground(new java.awt.Color(5, 4, 45));
        lbSubResp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSubResp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_responsavel.png"))); // NOI18N
        lbSubResp.setText("Responsável Legal");

        lbInfo.setBackground(new java.awt.Color(5, 4, 45));
        lbInfo.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        lbInfo.setForeground(new java.awt.Color(5, 4, 45));
        lbInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_info.png"))); // NOI18N
        lbInfo.setText("Informações Básicas");

        lbSubLim1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSubLim1.setForeground(new java.awt.Color(5, 4, 45));
        lbSubLim1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSubLim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_fisco.png"))); // NOI18N
        lbSubLim1.setText("Informações Fiscais");

        lbAno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAno.setText("Ano*");

        cboxAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019" }));
        cboxAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxAnoActionPerformed(evt);
            }
        });

        lbLimAnual.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLimAnual.setText("Limite Anual");

        txtLimAnual.setEditable(false);
        txtLimAnual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimAnual.setEnabled(false);

        lbLimMensal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLimMensal.setText("Limite Mensal");

        txtLimMensal.setEditable(false);
        txtLimMensal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimMensal.setEnabled(false);

        lbTipoTrib.setForeground(new java.awt.Color(5, 4, 45));
        lbTipoTrib.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTipoTrib.setText("Tributação");

        lbLimCompras.setText("Limite de Compras");

        txtLimCompras.setEditable(false);
        txtLimCompras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLimCompras.setEnabled(false);

        lbCNAE.setForeground(new java.awt.Color(5, 4, 45));
        lbCNAE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCNAE.setText("Atividade Principal*");

        cboxCNAE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        txtTributo.setEditable(false);
        txtTributo.setEnabled(false);

        txtCodCNAE.setEditable(false);
        txtCodCNAE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodCNAE.setEnabled(false);

        lbIE1.setForeground(new java.awt.Color(5, 4, 45));
        lbIE1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIE1.setText("Código CNAE");

        javax.swing.GroupLayout pnlEmpresaLayout = new javax.swing.GroupLayout(pnlEmpresa);
        pnlEmpresa.setLayout(pnlEmpresaLayout);
        pnlEmpresaLayout.setHorizontalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIE1)
                    .addComponent(txtCodCNAE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlEmpresaLayout.createSequentialGroup()
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbIE)
                                .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbIM)
                                .addComponent(txtIM, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCNAE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxCNAE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlEmpresaLayout.createSequentialGroup()
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbNome)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCNPJ)
                                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlEmpresaLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(lbAbertura))
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlEmpresaLayout.createSequentialGroup()
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbResponsavel))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCPF)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbFone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbEmail)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(lbSubResp)
                        .addComponent(lbSubLim1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbInfo)
                        .addGroup(pnlEmpresaLayout.createSequentialGroup()
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAno))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbLimAnual)
                                .addComponent(txtLimAnual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtLimMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbLimMensal))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtLimCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbLimCompras))
                            .addGap(18, 18, 18)
                            .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbTipoTrib)
                                .addComponent(txtTributo)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlEmpresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtLimAnual, txtLimCompras, txtLimMensal});

        pnlEmpresaLayout.setVerticalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbInfo)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lbNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpresaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCNPJ)))
                        .addGap(5, 5, 5)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lbAbertura)))
                .addGap(21, 21, 21)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addComponent(lbCNAE)
                        .addGap(5, 5, 5)
                        .addComponent(cboxCNAE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIE, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(5, 5, 5)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtIM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(lbIE1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodCNAE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(lbSubResp)
                .addGap(21, 21, 21)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbResponsavel)
                            .addComponent(lbFone)
                            .addComponent(lbCPF))
                        .addGap(5, 5, 5)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(lbSubLim1)
                .addGap(21, 21, 21)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbAno)
                    .addComponent(lbLimAnual)
                    .addComponent(lbLimMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLimCompras)
                    .addComponent(lbTipoTrib))
                .addGap(5, 5, 5)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cboxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimAnual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTributo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tbbEmpresa.addTab("Dados da Empresa", pnlEmpresa);

        pnlEndereco.setBackground(new java.awt.Color(255, 255, 255));
        pnlEndereco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbEndereco.setText("Logradouro*");

        lbBairro.setText("Bairro*");

        lbCidade.setText("Cidade*");

        lbUF.setText("UF*");

        cboxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lbCEP.setText("CEP*");

        lbComplemento.setText("Complemento");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(5, 4, 45));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_endereco_comercial.png"))); // NOI18N
        jLabel19.setText("Endereço Comercial");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbSubEnd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbSubEnd.setForeground(new java.awt.Color(5, 4, 45));
        lbSubEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_endereco_residencial.png"))); // NOI18N
        lbSubEnd.setText("Endereço Residencial");

        chkboxEnd.setText("Endereço comercial é o mesmo do residencial");
        chkboxEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkboxEndActionPerformed(evt);
            }
        });

        lbEndCom.setText("Logradouro*");

        lbBairroCom.setText("Bairro*");

        lbCidadeCom.setText("Cidade*");

        lbCompCom.setText("Complemento");

        lbUFCom.setText("UF*");

        cboxUFCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lbCEPCom.setText("CEP*");

        javax.swing.GroupLayout pnlEnderecoLayout = new javax.swing.GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEndereco)
                            .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbComplemento)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkboxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairro)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUF)
                            .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCidade)
                            .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(lbCEP)
                            .addComponent(txtCEP)))
                    .addComponent(jLabel19)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEndCom)
                            .addComponent(txtLogradouroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCompCom)
                            .addComponent(txtCompCom, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBairroCom)
                            .addComponent(txtBairroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUFCom)
                            .addComponent(cboxUFCom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCidadeCom)
                            .addComponent(txtCidadeCom, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(lbCEPCom)
                            .addComponent(txtCEPCom)))
                    .addComponent(lbSubEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 100, Short.MAX_VALUE))
        );
        pnlEnderecoLayout.setVerticalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbSubEnd)
                .addGap(21, 21, 21)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(lbBairro)
                    .addComponent(lbCidade))
                .addGap(5, 5, 5)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbComplemento)
                    .addComponent(lbUF)
                    .addComponent(lbCEP))
                .addGap(5, 5, 5)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkboxEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel19)
                .addGap(21, 21, 21)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndCom)
                    .addComponent(lbBairroCom)
                    .addComponent(lbCidadeCom))
                .addGap(5, 5, 5)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairroCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCompCom)
                    .addComponent(lbUFCom)
                    .addComponent(lbCEPCom))
                .addGap(5, 5, 5)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxUFCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEPCom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        tbbEmpresa.addTab("Endereço", pnlEndereco);

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Dados da Empresa");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));
        pnlButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalvar.setBackground(new java.awt.Color(5, 4, 45));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar dados (ALT +S)");
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(224, 224, 247));
        btnEditar.setForeground(new java.awt.Color(5, 4, 45));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar registro (ALT + E)");
        btnEditar.setIconTextGap(5);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(249, 249, 252));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar (ALT + X)");
        btnCancelar.setIconTextGap(10);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnEditar, btnSalvar});

        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnEditar, btnSalvar});

        pnlInferior.setBackground(new java.awt.Color(5, 4, 45));
        pnlInferior.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbbEmpresa))
                .addContainerGap())
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tbbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNome.getText().trim();
        String cnpj = txtCNPJ.getText().trim();
        String dataAbertura = txtData.getText();
        String ie = txtIE.getText().trim();
        String cnae = (String) cboxCNAE.getSelectedItem();
        String responsavel = txtResponsavel.getText().trim();
        String cpf = txtCPF.getText();
        String fone = txtFone.getText().trim();
        String email = txtEmail.getText().trim();
        String logradouro = txtLogradouro.getText().trim();
        String bairro = txtBairro.getText().trim();
        String cidade = txtCidade.getText().trim();
        String uf = (String) cboxUF.getSelectedItem();
        String cep = txtCEP.getText().trim();
        String ano = (String) cboxAno.getSelectedItem();
        String logradouroCom = txtLogradouroCom.getText().trim();
        String bairroCom = txtBairroCom.getText().trim();
        String cidadeCom = txtCidadeCom.getText().trim();
        String complementoCom = txtCompCom.getText().trim();
        String ufCom = (String) cboxUFCom.getSelectedItem();
        String cepCom = txtCEPCom.getText().trim();
        

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a Razão Social.");
            txtNome.requestFocusInWindow();
            return;
        }
            
        if (cnpj.isEmpty() || !cnpj.matches("[0-9]{2}[\\.][0-9]{3}[\\.][0-9]{3}[/][0-9]{4}[-][0-9]{2}")) {
            JOptionPane.showMessageDialog(null, "Informe o CNPJ da empresa!");
            txtCNPJ.requestFocusInWindow();
            return;
        }
                  
        if (!dataAbertura.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            JOptionPane.showMessageDialog(null, "Informe a data de abertura!");
            txtData.requestFocusInWindow(); 
            return;
        }
                            
        if (ie.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a inscrição estadual!");
            txtIE.requestFocusInWindow();
            return;
        }
        
       
        if  (cnae == null ||  cnae.equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Informe a atividade principal da empresa!");
            cboxCNAE.requestFocusInWindow();
            return;
        }
        if  (responsavel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do empresário individual!");
            txtResponsavel.requestFocusInWindow();
            return;
        }
           
        if  (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o número do CPF!");
            txtCPF.requestFocusInWindow();
            return;
        }
        
        if  (fone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe um telefone para contato!");
            txtFone.requestFocusInWindow();
            return;
        }
           
        if  (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe um E-mail contato!");
            txtEmail.requestFocusInWindow();
            return;
        }
           
        if  (ano == null ||  ano.equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Informe o exercício atual!");
            cboxAno.requestFocusInWindow();
            return;
        }
        
        if  (logradouro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o endereço residencial!");
            txtLogradouro.requestFocusInWindow();
            return;
        }
        
        if  (bairro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o bairro!");
            txtBairro.requestFocusInWindow();
            return;
        }
        
        if  (cidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a cidade!");
            txtCidade.requestFocusInWindow();
            return;
        }
        
        if  (uf == null || uf.equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Informe o estado!");
            cboxUF.requestFocusInWindow();
            return;
        }
        
        if  (cep.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o CEP!");
            txtCEP.requestFocusInWindow();
            return;
        }
        
        if  (logradouroCom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o endereço comercial!");
            txtLogradouroCom.requestFocusInWindow();
            return;
        }
        
        if  (bairroCom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o bairro comercial!");
            txtBairroCom.requestFocusInWindow();
            return;
        }
        if  (cidadeCom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a cidade comercial!");
            txtCidadeCom.requestFocusInWindow();
            return;
        }
        
        if  (ufCom == null || ufCom.equals("Selecione")) {
            JOptionPane.showMessageDialog(this, "Informe o estado comercial!");
            cboxUFCom.requestFocusInWindow();
            return;
        }
         
        if (cepCom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o CEP comercial!");
            txtCEPCom.requestFocusInWindow();
            return;
        }
            
        Endereco endereco = new Endereco(
        txtLogradouro.getText().trim(),
        txtBairro.getText().trim(),
        txtCidade.getText().trim(),
        txtComplemento.getText().trim(),
        (String) cboxUF.getSelectedItem(),
        txtCEP.getText().trim()
    );

        Endereco enderecoComercial = new Endereco(
        logradouroCom, bairroCom, cidadeCom, complementoCom, ufCom,cepCom);

    Atividade atividadePrincipal = AtividadeDAO.listaOcupacao(cnae);
    
    Empresa empresa = new Empresa(nome, cnpj, dataAbertura, txtIE.getText().trim(),
        txtIM.getText().trim(), endereco, txtResponsavel.getText().trim(), cpf,
        txtFone.getText().trim(),
        txtEmail.getText().trim()
    );

        empresa.setAno(ano);
        empresa.setEnderecoComercial(enderecoComercial);
        empresa.addAtividade(atividadePrincipal);

        if (empresaMEI == null) {
            EmpresaDAO.adicionar(empresa);
        } else {
            EmpresaDAO.atualizar(empresa);
        }
        empresaMEI = empresa;
        empresaMEI = empresa;

        EmpresaDAO.salvarAtividade(atividadePrincipal);
           
        bloquearCampos(false);
        btnEditar.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);

        JOptionPane.showMessageDialog(this, "Dados da empresa salvos com sucesso!");

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (usuarioLogado == null || !usuarioLogado.getTipo().equalsIgnoreCase("Gerente")) {
        JOptionPane.showMessageDialog(this, "Apenas o Gerente pode editar os dados da empresa.", "Acesso negado",
                JOptionPane.WARNING_MESSAGE);
        return;
        }
        
        bloquearCampos(true);
        btnEditar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         
         if (empresaMEI != null) {
            preencherCampos();
            bloquearCampos(false);
            btnEditar.setEnabled(true);
         
         } else {
            limparCampos();
            bloquearCampos(true);
            btnEditar.setEnabled(false);
            btnCancelar.setEnabled(true);
        }

        btnSalvar.setEnabled(empresaMEI == null);
        btnCancelar.setEnabled(false);

        JOptionPane.showMessageDialog(this, "Operação cancelada!", "Cancelada", JOptionPane.WARNING_MESSAGE);
    
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboxAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxAnoActionPerformed
        anoFaturamento();
    }//GEN-LAST:event_cboxAnoActionPerformed

    private void chkboxEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkboxEndActionPerformed
       
     if (chkboxEnd.isSelected()) {

        txtLogradouroCom.setText(txtLogradouro.getText());
        txtBairroCom.setText(txtBairro.getText());
        txtCidadeCom.setText(txtCidade.getText());
        txtCompCom.setText(txtComplemento.getText());
        cboxUFCom.setSelectedIndex(cboxUF.getSelectedIndex());
        txtCEPCom.setText(txtCEP.getText());
        
     } else {
        txtLogradouroCom.setText("");
        txtBairroCom.setText("");
        txtCidadeCom.setText("");
        txtCompCom.setText("");
        cboxUFCom.setSelectedIndex(0);
        txtCEPCom.setText("");
   
     }
    }//GEN-LAST:event_chkboxEndActionPerformed
    
    
      // formatacao
    
    private void formatacaoVisual () {
        
         //placeholder
         txtNome.putClientProperty("JTextField.placeholderText", "Nome Empresarial...");
         txtLogradouro.putClientProperty("JTextField.placeholderText", "Logradouro, nº da casa/apartamento...");
         txtLogradouroCom.putClientProperty("JTextField.placeholderText", "Logradouro, nº casa/apartamento...");
         
         
    }
    
    private String formatarValorCampo(double valor) {
            
        DecimalFormatSymbols brSymbols = new DecimalFormatSymbols(java.util.Locale.of("pt", "BR"));
        DecimalFormat brFormat = new DecimalFormat("#,##0.00", brSymbols);
        return brFormat.format(valor);
}
    

    private void formatoData(javax.swing.JFormattedTextField campo) {
       
        try {
            javax.swing.text.MaskFormatter formatoData = new javax.swing.text.MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter(' ');
            formatoData.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    private void formatoCNPJ(javax.swing.JFormattedTextField campo) {

    try {
        javax.swing.text.MaskFormatter formatoCNPJ =
                new javax.swing.text.MaskFormatter("##.###.###/####-##");

        formatoCNPJ.setPlaceholderCharacter(' ');
        formatoCNPJ.install(campo);

    } catch (java.text.ParseException e) {
        e.printStackTrace();
    }
}
    
    private void formatoCPF(javax.swing.JFormattedTextField campo) {
        
        try {
            javax.swing.text.MaskFormatter formatoCPF = new javax.swing.text.MaskFormatter("###.###.###-##");
            formatoCPF.setPlaceholderCharacter(' ');
            formatoCPF.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    private void formatoFone(javax.swing.JFormattedTextField campo) {
       
        try {
            javax.swing.text.MaskFormatter formatoFone = new javax.swing.text.MaskFormatter("(##) #####-####");
            formatoFone.setPlaceholderCharacter(' ');
            formatoFone.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
 
   
    private void formatoCEP(javax.swing.JFormattedTextField campo) {

    try {
        javax.swing.text.MaskFormatter formatoCEP =
                new javax.swing.text.MaskFormatter("#####-###");

        formatoCEP.setPlaceholderCharacter(' ');
        formatoCEP.install(campo);

    } catch (java.text.ParseException e) {
        e.printStackTrace();
    }
    }

    private void geraAcessbilidade() {

    btnSalvar.setMnemonic(KeyEvent.VK_S);
    btnEditar.setMnemonic(KeyEvent.VK_E);
    btnCancelar.setMnemonic(KeyEvent.VK_X);
    
    
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboxAno;
    private javax.swing.JComboBox<String> cboxCNAE;
    private javax.swing.JComboBox<String> cboxUF;
    private javax.swing.JComboBox<String> cboxUFCom;
    private javax.swing.JCheckBox chkboxEnd;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel lbAbertura;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbBairroCom;
    private javax.swing.JLabel lbCEP;
    private javax.swing.JLabel lbCEPCom;
    private javax.swing.JLabel lbCNAE;
    private javax.swing.JLabel lbCNPJ;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbCidadeCom;
    private javax.swing.JLabel lbCompCom;
    private javax.swing.JLabel lbComplemento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndCom;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbFone;
    private javax.swing.JLabel lbIE;
    private javax.swing.JLabel lbIE1;
    private javax.swing.JLabel lbIM;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbLimAnual;
    private javax.swing.JLabel lbLimCompras;
    private javax.swing.JLabel lbLimMensal;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbResponsavel;
    private javax.swing.JLabel lbSubEnd;
    private javax.swing.JLabel lbSubLim1;
    private javax.swing.JLabel lbSubResp;
    private javax.swing.JLabel lbTipoTrib;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUF;
    private javax.swing.JLabel lbUFCom;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlEmpresa;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTabbedPane tbbEmpresa;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairroCom;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCEPCom;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCidadeCom;
    private javax.swing.JTextField txtCodCNAE;
    private javax.swing.JTextField txtCompCom;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtIM;
    private javax.swing.JTextField txtLimAnual;
    private javax.swing.JTextField txtLimCompras;
    private javax.swing.JTextField txtLimMensal;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtLogradouroCom;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtTributo;
    // End of variables declaration//GEN-END:variables

       
}
