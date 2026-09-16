package view;

import dao.LancamentoDAO;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Lancamento;
import model.Movimento;

public class LancamentoPanel extends javax.swing.JFrame {
    
/**
 * Tela de lançamentos financeiros (receita, despesa, custos e compras).
 *
 * @author Elane
 */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LancamentoPanel.class.getName());
    private ResumoPanel resumo;
    private ReceitaPanel receita;
    private DespesaPanel despesa;
    private Lancamento editarRegistro;

    
    public LancamentoPanel(ResumoPanel resumo, ReceitaPanel receita, DespesaPanel despesa, Lancamento editarRegistro) {
        iniciarTela();
        this.resumo = resumo;
        this.receita = receita;
        this.despesa = despesa;
        this.editarRegistro = editarRegistro;

        if (editarRegistro != null) {
            lbTitulo.setText("Editar Lançamento");
            preencherCampos();
        } else {
            lbTitulo.setText("+ Novo Lançamento");
        }
        
    }
    
    
    public LancamentoPanel(ResumoPanel resumo, ReceitaPanel receita, DespesaPanel despesa) {
        this(resumo, receita, despesa, null);
    }
    
    private void iniciarTela () {
        initComponents();
        formatacaoVisual();
        formatarData(txtData);
        formatarData(txtDataVenc);
        formatarData(txtDataLiq);
        
        geraAcessbilidade();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox<>();
        lblData = new javax.swing.JLabel();
        lblVenc = new javax.swing.JLabel();
        lblCusto = new javax.swing.JLabel();
        cboxSetor = new javax.swing.JComboBox<>();
        lblConta = new javax.swing.JLabel();
        cboxConta = new javax.swing.JComboBox<>();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblVlrOriginal = new javax.swing.JLabel();
        txtVlrOriginal = new javax.swing.JTextField();
        lblStatus1 = new javax.swing.JLabel();
        cboxClienteFor = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        cboxStatus = new javax.swing.JComboBox<>();
        lblPgto = new javax.swing.JLabel();
        lbForma = new javax.swing.JLabel();
        cboxForma = new javax.swing.JComboBox<>();
        txtVlrLiq = new javax.swing.JTextField();
        lblVlrLiq = new javax.swing.JLabel();
        lblJuros = new javax.swing.JLabel();
        txtJuros = new javax.swing.JTextField();
        lblDesconto = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        pnlInferior = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDataVenc = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtDataLiq = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lançamento");
        setName(""); // NOI18N
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(234, 239, 255));
        pnlPrincipal.setForeground(new java.awt.Color(5, 4, 45));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(650, 500));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("+ Novo Lancamento");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        lblID.setForeground(new java.awt.Color(5, 4, 45));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblID.setText("ID:");

        txtID.setEditable(false);
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setToolTipText("");
        txtID.setEnabled(false);
        txtID.setPreferredSize(new java.awt.Dimension(64, 25));

        lblTipo.setForeground(new java.awt.Color(5, 4, 45));
        lblTipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTipo.setText("Tipo de Movimento:");

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Receita", "Despesa", "Compra", "Custo" }));
        cboxTipo.setPreferredSize(new java.awt.Dimension(64, 25));

        lblData.setForeground(new java.awt.Color(5, 4, 45));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData.setText("Data da Operação:");

        lblVenc.setForeground(new java.awt.Color(5, 4, 45));
        lblVenc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVenc.setText("Data de Vencimento:");

        lblCusto.setForeground(new java.awt.Color(5, 4, 45));
        lblCusto.setText("Setor:");

        cboxSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "GERAL", "ADMINISTRATIVO", "TRANSPORTES", "COMERCIAL", "VENDAS" }));
        cboxSetor.setPreferredSize(new java.awt.Dimension(0, 25));

        lblConta.setBackground(new java.awt.Color(5, 4, 45));
        lblConta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblConta.setText("Subconta:");

        cboxConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Combustível e Lubrificantes", "Material de Expediente", "Salários", "Venda de Mercadorias", "Compra de Mercadorias", "Serviços Prestados", "Manutenção Diversas" }));
        cboxConta.setPreferredSize(new java.awt.Dimension(0, 25));

        lblDescricao.setForeground(new java.awt.Color(5, 4, 45));
        lblDescricao.setText("Descrição:");

        txtDescricao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescricao.setPreferredSize(new java.awt.Dimension(0, 25));

        lblVlrOriginal.setForeground(new java.awt.Color(5, 4, 45));
        lblVlrOriginal.setText("Valor Original (R$):");

        txtVlrOriginal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVlrOriginal.setPreferredSize(new java.awt.Dimension(0, 25));
        txtVlrOriginal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVlrOriginalFocusLost(evt);
            }
        });

        lblStatus1.setBackground(new java.awt.Color(5, 4, 45));
        lblStatus1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblStatus1.setText("Cliente/Fornecedor:");

        cboxClienteFor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Cliente A", "Cliente B", "Fornecedor A", "Fornecedor B" }));
        cboxClienteFor.setPreferredSize(new java.awt.Dimension(0, 25));

        lblStatus.setForeground(new java.awt.Color(5, 4, 45));
        lblStatus.setText("Status:");

        cboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Liquidado", "Não Liquidado" }));
        cboxStatus.setPreferredSize(new java.awt.Dimension(0, 25));

        lblPgto.setBackground(new java.awt.Color(5, 4, 45));
        lblPgto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPgto.setText("Liquidado em:");

        lbForma.setForeground(new java.awt.Color(5, 4, 45));
        lbForma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbForma.setText("Forma Rec./Pgto:");

        cboxForma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Pix", "Débito", "Crédito", "Espécie", "TED", "Depósito", "Boleto", "Outros" }));
        cboxForma.setPreferredSize(new java.awt.Dimension(0, 25));

        txtVlrLiq.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVlrLiq.setPreferredSize(new java.awt.Dimension(0, 25));
        txtVlrLiq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtVlrLiqFocusLost(evt);
            }
        });

        lblVlrLiq.setBackground(new java.awt.Color(5, 4, 45));
        lblVlrLiq.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVlrLiq.setText("Valor Liquidado (R$):");

        lblJuros.setForeground(new java.awt.Color(5, 4, 45));
        lblJuros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJuros.setText("Juros (R$):");

        txtJuros.setEditable(false);
        txtJuros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJuros.setPreferredSize(new java.awt.Dimension(0, 25));

        lblDesconto.setBackground(new java.awt.Color(5, 4, 45));
        lblDesconto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDesconto.setText("Desconto (R$):");

        txtDesconto.setEditable(false);
        txtDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesconto.setPreferredSize(new java.awt.Dimension(0, 25));

        pnlInferior.setBackground(new java.awt.Color(255, 255, 255));
        pnlInferior.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalvar.setBackground(new java.awt.Color(5, 4, 45));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar (ALT + S)");
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnSalvar)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar)
                .addGap(200, 200, 200))
        );

        pnlInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnSalvar});

        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        txtDataVenc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDataLiq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVlrOriginal)
                            .addComponent(lbForma, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblData))
                            .addComponent(lblID))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxForma, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVlrOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                                .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                                .addComponent(lblVlrLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                                                        .addComponent(lblConta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)))
                                                .addGap(19, 19, 19))))
                                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(lblPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(lblDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtVlrLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxClienteFor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTipo)
                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVenc)
                    .addComponent(txtDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusto)
                    .addComponent(lblConta)
                    .addComponent(cboxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStatus1)
                    .addComponent(cboxClienteFor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVlrOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVlrOriginal))
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStatus)
                    .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbForma)
                            .addComponent(cboxForma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVlrLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVlrLiq))))
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDesconto)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblJuros)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(txtDataLiq, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(lblPgto)))
                .addGap(206, 206, 206))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

        
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
    String tipoMovimento = (String) cboxTipo.getSelectedItem(); 
    String dataOperacao = txtData.getText();
    String dataVencimento = txtDataVenc.getText();
    String setor = (String) cboxSetor.getSelectedItem();
    String contas = (String) cboxConta.getSelectedItem();
    String descricao = txtDescricao.getText();
    String clienteFor = (String) cboxClienteFor.getSelectedItem();
    String status = (String) cboxStatus.getSelectedItem();
    String dataLiquidacao = txtDataLiq.getText();
    String formas = (String) cboxForma.getSelectedItem();
    double valorOrig;
    double valorLiquidado;
    double juros = 0;
    double desconto = 0;
    
    
    // regras de validacao
        
    if (tipoMovimento == null || tipoMovimento.equals("Selecione")) {       
        JOptionPane.showMessageDialog(null, "O Campo 'Tipo de Movimento' deve ser preenchido!");
        cboxTipo.requestFocusInWindow(); 
        return;
    }
        
    if (!dataOperacao.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
        JOptionPane.showMessageDialog(null, "O campo 'Data da Operação' deve ser preenchido!");
        txtData.requestFocusInWindow();
        return;
    }
        
    if (!dataVencimento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
        JOptionPane.showMessageDialog(null, "O campo 'Data de Vencimento' deve ser preenchido!");
        txtDataVenc.requestFocusInWindow();
        return;
    }
    
    if (setor == null ||  setor.equals("Selecione")) {
        JOptionPane.showMessageDialog(null, "O campo 'Setor' deve ser preenchido!");
        cboxSetor.requestFocusInWindow();
    return;
    }
    
    if (contas == null ||  contas.equals("Selecione")) {
        JOptionPane.showMessageDialog(null, "O campo 'Subconta' deve ser preenchido!");
        cboxConta.requestFocusInWindow();
    return;
    
    }    
    
    if (descricao.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Descrição' deve ser preenchido!");
        txtDescricao.requestFocusInWindow();
    return;
    }
    
    if (clienteFor == null || clienteFor.equals("Selecione")){
        JOptionPane.showMessageDialog(null, "O campo 'Cliente/Fornecedor' deve ser preenchido!");
        cboxClienteFor.requestFocusInWindow();
   return;
    }
    
    if (status == null || status.equals("Selecione")){
        JOptionPane.showMessageDialog(null, "O campo 'Status' deve ser preenchido!");
        cboxStatus.requestFocusInWindow();
    return;
    }
    
    //campo não obrigatorio
    boolean dataInformada = !dataLiquidacao.replaceAll("[/\\s]", "").isEmpty();

    if (dataInformada && !dataLiquidacao.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
        JOptionPane.showMessageDialog(null, "Informe uma 'Data de Liquidação' válida, ou deixe em branco!");
        txtDataLiq.requestFocusInWindow();
    return;
    }

    if (!dataInformada) {
        dataLiquidacao = "";
    }

     {
    }
    
    if (formas == null || formas.equals("Selecione")){
        JOptionPane.showMessageDialog(null, "O campo 'Forma de Pagamento/Recebimento' deve ser preenchido!");
        cboxForma.requestFocusInWindow();
     return;
    }
    
        
    try {
        valorOrig = Double.parseDouble(txtVlrOriginal.getText().trim().replace(".", "").replace(",", "."));
        String vlrLiqTexto = txtVlrLiq.getText().trim();
        
        valorLiquidado = vlrLiqTexto.isEmpty() ? 0.0 : Double.parseDouble(vlrLiqTexto.replace(".", "").replace(",", "."));
   
    } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Verifique os valores informados!. Use apenas números!");
               
                return;
            }
    
    calcJurosDescontos();
        juros = Double.parseDouble(txtJuros.getText().replace(",", "."));
        desconto = Double.parseDouble(txtDesconto.getText().replace(",", "."));
        
        
        DateTimeFormatter formato = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate.parse(dataOperacao, formato);
                    
        } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(null, "Informe uma data válida!", "Campo Obrigatório!",
                JOptionPane.ERROR_MESSAGE);
            txtData.requestFocusInWindow();
            return;
        }
        
         try {
            LocalDate.parse(dataVencimento, formato);
       
        } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(null, "Informe uma data válida!", "Campo Obrigatório!",
                JOptionPane.ERROR_MESSAGE);
            txtDataVenc.requestFocusInWindow();
            return;
        }
         
        if (dataInformada) {
            
        try {
            LocalDate.parse(dataLiquidacao, formato);
        
        } catch (DateTimeParseException e) {
            
            JOptionPane.showMessageDialog(null, "Informe uma data válida!", "Campo Obrigatório!",
                    JOptionPane.ERROR_MESSAGE);
            txtDataLiq.requestFocusInWindow();
            
            return;
        }

        }
        
    Movimento tipo = null;

    switch (tipoMovimento) {
        case "Receita":
            tipo = Movimento.RECEITA;
            break;
        case "Despesa":
            tipo = Movimento.DESPESA;
            break;
        case "Compra":
            tipo = Movimento.COMPRAS;
            break;
        case "Custo":
            tipo = Movimento.COMPRAS;
            break;
        default:
            JOptionPane.showMessageDialog(null, "Tipo de movimento inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
}
    if (editarRegistro != null) {
      editarRegistro.setTipo(tipo);
      editarRegistro.setDataOperacao(dataOperacao);
      editarRegistro.setDataVencimento(dataVencimento);
      editarRegistro.setSetor(setor);
      editarRegistro.setContas(contas);
      editarRegistro.setDescricao(descricao);
      editarRegistro.setValorOrig(valorOrig);
      editarRegistro.setClienteFornecedor(clienteFor);
      editarRegistro.setStatus(status);
      editarRegistro.setDataLiquidacao(dataLiquidacao);
      editarRegistro.setFormas(formas);
      editarRegistro.setValorLiquidado(valorLiquidado);
      editarRegistro.setJuros(juros);
      editarRegistro.setDesconto(desconto);
      
      LancamentoDAO.editar(editarRegistro);
      
      
  } else {
    
  Lancamento l = new Lancamento(tipo, dataOperacao, dataVencimento, setor, contas, descricao,
           valorOrig, clienteFor, status, dataLiquidacao, formas, valorLiquidado, juros, desconto); 
   
            LancamentoDAO.adicionar(l);
            txtID.setText(String.valueOf(l.getId()));
    }
            if (resumo != null) resumo.carregarTabela();
            if (receita != null) receita.carregarTabela();
            if (despesa != null) despesa.carregarTabela();
                             
            JOptionPane.showMessageDialog(null, "Lançamento efetuado com sucesso!", "Salvo", JOptionPane.INFORMATION_MESSAGE);

            limparCampos();
    
        
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void preencherCampos() {
        
        cboxTipo.setSelectedItem(editarRegistro.getTipo().toString());
        txtData.setText(editarRegistro.getDataOperacao());
        txtDataVenc.setText(editarRegistro.getDataVencimento());
        cboxSetor.setSelectedItem(editarRegistro.getSetor());
        cboxConta.setSelectedItem(editarRegistro.getContas());
        txtDescricao.setText(editarRegistro.getDescricao());
        txtVlrOriginal.setText(formatarValorCampo(editarRegistro.getValorOrig()));
        cboxClienteFor.setSelectedItem(editarRegistro.getClienteFornecedor());
        cboxStatus.setSelectedItem(editarRegistro.getStatus());
        txtDataLiq.setText(editarRegistro.getDataLiquidacao());
        cboxForma.setSelectedItem(editarRegistro.getFormas());
        
        if (editarRegistro.getValorLiquidado() > 0) {
            txtVlrLiq.setText(formatarValorCampo(editarRegistro.getValorLiquidado()));
            calcJurosDescontos();
        } else {
            
        txtVlrLiq.setText("");
}
        
       txtID.setText(String.valueOf(editarRegistro.getId()));
    }
    
    private void txtVlrLiqFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVlrLiqFocusLost
        formatoNumerico(txtVlrLiq);
        calcJurosDescontos();
        
    }//GEN-LAST:event_txtVlrLiqFocusLost

    private void txtVlrOriginalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtVlrOriginalFocusLost
        formatoNumerico(txtVlrOriginal);
        calcJurosDescontos();
        
        
    }//GEN-LAST:event_txtVlrOriginalFocusLost
  
   private void calcJurosDescontos () {

    try {
        double valorOrig = Double.parseDouble(txtVlrOriginal.getText().trim().replace(".", "").replace(",", "."));

        String liqTexto = txtVlrLiq.getText().trim();

        double juros = 0;
        double desconto = 0;

        if (!liqTexto.isEmpty()) {
            double valorLiquidado = Double.parseDouble(liqTexto.replace(".", "").replace(",", "."));

            if (valorOrig > valorLiquidado) {
                desconto = valorOrig - valorLiquidado;
            } else if (valorOrig < valorLiquidado) {
                juros = valorLiquidado - valorOrig;
            }
        }

        txtJuros.setText(String.format("%.2f", juros));
        txtDesconto.setText(String.format("%.2f", desconto));

    } catch (NumberFormatException e) {
        txtJuros.setText("0.00");
        txtDesconto.setText("0.00");
    }
}
    
    private void limparCampos () {
        
        txtID.setText("");
        cboxTipo.setSelectedIndex(0);
        txtData.setText("");
        txtDataVenc.setText("");
        cboxSetor.setSelectedIndex(0);
        cboxConta.setSelectedIndex(0);
        txtDescricao.setText("");
        txtVlrOriginal.setText("");
        cboxClienteFor.setSelectedIndex(0);
        cboxStatus.setSelectedIndex(0);
        txtDataLiq.setText("");
        cboxForma.setSelectedIndex(0);
        txtVlrLiq.setText("");
        txtJuros.setText("");
        txtDesconto.setText("");
        
               
        cboxTipo.requestFocus();
        
    }
      
    private String formatarValorCampo(double valor) {
            
        DecimalFormatSymbols brSymbols = new DecimalFormatSymbols(java.util.Locale.of("pt", "BR"));
        DecimalFormat brFormat = new DecimalFormat("#,##0.00", brSymbols);
        return brFormat.format(valor);
}
    
    private void formatoNumerico(JTextField campoValor) {
    
    try {
        String texto = campoValor.getText().trim();
        if (texto.isEmpty()) {
            return;
        }
        double valor = Double.parseDouble(texto.replace(".", "").replace(",", "."));
        campoValor.setText(formatarValorCampo(valor));
        
    } catch (NumberFormatException e) {
        campoValor.setText("0,00");
    }
}
    
    private void formatarData (javax.swing.JFormattedTextField campoData){
   
    try {
        javax.swing.text.MaskFormatter formatoData = new javax.swing.text.MaskFormatter("##/##/####");
        formatoData.setPlaceholderCharacter(' ');
        formatoData.install(campoData);

    } catch (java.text.ParseException e) {
    e.printStackTrace();
    
    } 
   }
     
    private void formatacaoVisual () {
        
         //placeholder
         txtDescricao.putClientProperty("JTextField.placeholderText", "Descrição...");
    }
   
    private void geraAcessbilidade() {

    btnSalvar.setMnemonic(KeyEvent.VK_S);
    btnCancelar.setMnemonic(KeyEvent.VK_X);
    
    
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboxClienteFor;
    private javax.swing.JComboBox<String> cboxConta;
    private javax.swing.JComboBox<String> cboxForma;
    private javax.swing.JComboBox<String> cboxSetor;
    private javax.swing.JComboBox<String> cboxStatus;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JLabel lbForma;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblConta;
    private javax.swing.JLabel lblCusto;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblJuros;
    private javax.swing.JLabel lblPgto;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblVenc;
    private javax.swing.JLabel lblVlrLiq;
    private javax.swing.JLabel lblVlrOriginal;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDataLiq;
    private javax.swing.JFormattedTextField txtDataVenc;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJuros;
    private javax.swing.JTextField txtVlrLiq;
    private javax.swing.JTextField txtVlrOriginal;
    // End of variables declaration//GEN-END:variables
}
