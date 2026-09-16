package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import theme.Temas;
import model.Lancamento;
import dao.LancamentoDAO;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Movimento;
import model.Usuario;


/**
 * Painel de resumo financeiro. Exibe os lançamentos e totalizadores e
 * filtros de dados.
 *
 * @author Elane
 */

public class ResumoPanel extends javax.swing.JPanel {
    
   private DefaultTableModel modelTabela;
   private ReceitaPanel receitaPanel;
   private DespesaPanel despesaPanel;
   private List<Lancamento> listaLancamentos;
   
public void exibePanel (ReceitaPanel receitaPanel, DespesaPanel despesaPanel){
    this.receitaPanel = receitaPanel;
    this.despesaPanel = despesaPanel;
    
}

public ResumoPanel(Usuario u) {
      initComponents();
      formatacaoVisual();
      centralizarDadosTab();
      mascaraData(fDe);
      mascaraData(fAte);
         
              
      modelTabela = (DefaultTableModel) tblResumo.getModel();
      carregarTabela();
      geraAcessbilidade();
      Temas.addVersao(pnlInferior);
      
    }
   
    public void carregarTabela (){
        
        preencherTabela();
    
    }
    private void preencherTabela() {
    
        preencherTabela(LancamentoDAO.listar());
    
    }

    private void preencherTabela(List<Lancamento> lista) {
    
    this.listaLancamentos = lista;  
    modelTabela.setNumRows(0);

    if (lista != null) {
        for (Lancamento l : lista) {
            Object[] obj = new Object[]{
                l.getTipo(),
                l.getDataOperacao(),
                l.getSetor(),
                l.getContas(),
                formatoNumerico(l.getValorOrig()),
                l.getDescricao(),
                l.getClienteFornecedor(),
                l.getFormas(),
                l.getDataVencimento(),
                l.getStatus(),
                l.getDataLiquidacao(),
                formatoNumerico(l.getValorLiquidado()),
                formatoNumerico(l.getJuros()),
                formatoNumerico(l.getDesconto())
            };
            modelTabela.addRow(obj);
        }
    }
        totalizadores(lista);
        lbTotRegistro.setText(lista != null ? Integer.toString(lista.size()) : "0");
}     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCard = new javax.swing.JPanel();
        pnlPagar = new javax.swing.JPanel();
        lbPagar = new javax.swing.JLabel();
        lblTotPagar = new javax.swing.JLabel();
        pnlReceber = new javax.swing.JPanel();
        lblReceber = new javax.swing.JLabel();
        lblTotReceber = new javax.swing.JLabel();
        pnlLucro = new javax.swing.JPanel();
        lblLucro = new javax.swing.JLabel();
        lblTotLucro = new javax.swing.JLabel();
        pnlDespesas = new javax.swing.JPanel();
        lblDespesas = new javax.swing.JLabel();
        lblTotDespesas = new javax.swing.JLabel();
        pnlReceita = new javax.swing.JPanel();
        lblReceitas = new javax.swing.JLabel();
        lblTotReceitas = new javax.swing.JLabel();
        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlTabela = new javax.swing.JPanel();
        scrResumo = new javax.swing.JScrollPane();
        tblResumo = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        lbFiltrar = new javax.swing.JLabel();
        cboxFiltro = new javax.swing.JComboBox<>();
        fDe = new javax.swing.JFormattedTextField();
        lbAte = new javax.swing.JLabel();
        fAte = new javax.swing.JFormattedTextField();
        lbPeriodo = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        cboxStatus = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLancamento = new javax.swing.JButton();
        lbRegistro = new javax.swing.JLabel();
        lbTotRegistro = new javax.swing.JLabel();
        cboxConta = new javax.swing.JComboBox<>();
        lbCliente1 = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        pnlPagar.setBackground(new java.awt.Color(249, 249, 252));
        pnlPagar.setPreferredSize(new java.awt.Dimension(210, 90));
        pnlPagar.setRequestFocusEnabled(false);

        lbPagar.setForeground(new java.awt.Color(102, 0, 102));
        lbPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_pagar.png"))); // NOI18N
        lbPagar.setText("A Pagar");

        lblTotPagar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        lblTotPagar.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlPagarLayout = new javax.swing.GroupLayout(pnlPagar);
        pnlPagar.setLayout(pnlPagarLayout);
        pnlPagarLayout.setHorizontalGroup(
            pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPagarLayout.createSequentialGroup()
                        .addComponent(lbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPagarLayout.setVerticalGroup(
            pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagarLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbPagar)
                .addGap(8, 8, 8)
                .addComponent(lblTotPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pnlReceber.setBackground(new java.awt.Color(249, 249, 252));
        pnlReceber.setPreferredSize(new java.awt.Dimension(210, 90));

        lblReceber.setForeground(new java.awt.Color(255, 204, 0));
        lblReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_receber.png"))); // NOI18N
        lblReceber.setText("A Receber");

        lblTotReceber.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        lblTotReceber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlReceberLayout = new javax.swing.GroupLayout(pnlReceber);
        pnlReceber.setLayout(pnlReceberLayout);
        pnlReceberLayout.setHorizontalGroup(
            pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlReceberLayout.createSequentialGroup()
                        .addComponent(lblReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlReceberLayout.setVerticalGroup(
            pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceberLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblReceber)
                .addGap(8, 8, 8)
                .addComponent(lblTotReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pnlLucro.setBackground(new java.awt.Color(249, 249, 252));
        pnlLucro.setPreferredSize(new java.awt.Dimension(210, 90));

        lblLucro.setForeground(new java.awt.Color(3, 8, 255));
        lblLucro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_lucro.png"))); // NOI18N
        lblLucro.setText("Lucro ");

        lblTotLucro.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        lblTotLucro.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlLucroLayout = new javax.swing.GroupLayout(pnlLucro);
        pnlLucro.setLayout(pnlLucroLayout);
        pnlLucroLayout.setHorizontalGroup(
            pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLucroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotLucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLucroLayout.setVerticalGroup(
            pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLucroLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lblTotLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pnlDespesas.setBackground(new java.awt.Color(249, 249, 252));
        pnlDespesas.setPreferredSize(new java.awt.Dimension(210, 90));

        lblDespesas.setForeground(new java.awt.Color(204, 0, 0));
        lblDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_despesa.png"))); // NOI18N
        lblDespesas.setText("Despesas");

        lblTotDespesas.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        lblTotDespesas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlDespesasLayout = new javax.swing.GroupLayout(pnlDespesas);
        pnlDespesas.setLayout(pnlDespesasLayout);
        pnlDespesasLayout.setHorizontalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDespesasLayout.setVerticalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblDespesas)
                .addGap(8, 8, 8)
                .addComponent(lblTotDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pnlReceita.setBackground(new java.awt.Color(249, 249, 252));
        pnlReceita.setPreferredSize(new java.awt.Dimension(210, 90));

        lblReceitas.setForeground(new java.awt.Color(0, 204, 102));
        lblReceitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReceitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_cifrao.png"))); // NOI18N
        lblReceitas.setText("Receitas");
        lblReceitas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTotReceitas.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        lblTotReceitas.setForeground(new java.awt.Color(5, 4, 45));
        lblTotReceitas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlReceitaLayout = new javax.swing.GroupLayout(pnlReceita);
        pnlReceita.setLayout(pnlReceitaLayout);
        pnlReceitaLayout.setHorizontalGroup(
            pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotReceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlReceitaLayout.setVerticalGroup(
            pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceitaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblReceitas)
                .addGap(8, 8, 8)
                .addComponent(lblTotReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlLucro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(pnlReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(pnlDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        pnlCardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlDespesas, pnlReceita});

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(200, 25));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Resumo");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addComponent(lbTitulo)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnlTabela.setBackground(new java.awt.Color(249, 249, 252));
        pnlTabela.setLayout(new java.awt.BorderLayout());

        scrResumo.setBackground(new java.awt.Color(249, 249, 252));
        scrResumo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrResumo.setMinimumSize(new java.awt.Dimension(10, 10));

        tblResumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Movimento", "Data", "Setor", "Subconta", "Valor", "Descrição", "Cliente/Fornecedor", "Forma de Pgto/Rec.", "Data de Venc.", "Status", "Liquidado em", "Valor Rec./Pago", "Juros", "Desconto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResumo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblResumo.setMinimumSize(new java.awt.Dimension(10, 10));
        tblResumo.setOpaque(false);
        scrResumo.setViewportView(tblResumo);
        if (tblResumo.getColumnModel().getColumnCount() > 0) {
            tblResumo.getColumnModel().getColumn(0).setMinWidth(150);
            tblResumo.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblResumo.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        pnlTabela.add(scrResumo, java.awt.BorderLayout.CENTER);

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));

        lbFiltrar.setText("Filtrar por:");

        cboxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Período", "Subconta", "Status", " " }));
        cboxFiltro.setToolTipText("Escolha um tipo");
        cboxFiltro.setMinimumSize(new java.awt.Dimension(10, 10));

        fDe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbAte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAte.setText("até");

        fAte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbPeriodo.setText("Período");

        lbStatus.setText("Status");

        cboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Liquidado", "Não Liquidado" }));

        btnPesquisar.setBackground(new java.awt.Color(53, 106, 227));
        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setToolTipText("Pesquisar (ALT + P)");
        btnPesquisar.setIconTextGap(5);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(249, 249, 252));
        btnLimpar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_esfregao.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar (ALT + L)");
        btnLimpar.setIconTextGap(5);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(249, 249, 252));
        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir (ALT + D)");
        btnExcluir.setIconTextGap(5);
        btnExcluir.setMinimumSize(new java.awt.Dimension(10, 10));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(224, 224, 247));
        btnEditar.setForeground(new java.awt.Color(5, 4, 45));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar (ALT + E)");
        btnEditar.setIconTextGap(5);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLancamento.setBackground(new java.awt.Color(5, 4, 45));
        btnLancamento.setForeground(new java.awt.Color(255, 255, 255));
        btnLancamento.setText("+ lançamento");
        btnLancamento.setToolTipText("Adicionar Movimento (ALT + N)");
        btnLancamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancamentoActionPerformed(evt);
            }
        });

        lbRegistro.setText("Total de registros:");

        lbTotRegistro.setBackground(new java.awt.Color(5, 4, 45));
        lbTotRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotRegistro.setText("0");

        cboxConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Combustível e Lubrificantes", "Material de Expediente", "Salários", "Venda de Mercadorias", "Compra de Mercadorias", "Serviços Prestados" }));

        lbCliente1.setText("Subconta");

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbFiltrar)
                        .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPeriodo)
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAte, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(lbCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(lbStatus))
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(cboxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(187, Short.MAX_VALUE))
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fAte, fDe});

        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCliente1)
                        .addComponent(lbStatus))
                    .addComponent(lbFiltrar)
                    .addComponent(lbPeriodo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxConta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTotRegistro)
                    .addComponent(lbRegistro)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancamentoActionPerformed
        
        LancamentoPanel telaLancamento = new LancamentoPanel (this, receitaPanel, despesaPanel);
        telaLancamento.setVisible(true);
    }//GEN-LAST:event_btnLancamentoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       
    String filtro = (String) cboxFiltro.getSelectedItem();
    List<Lancamento> todos = LancamentoDAO.listar();
    List<Lancamento> filtrados = new java.util.ArrayList<>();

    switch (filtro) {
        case "Período":
            String de = fDe.getText().trim();
            String ate = fAte.getText().trim();
            for (Lancamento l : todos) {
                if (intervaloData(l.getDataOperacao(), de, ate)) {
                    filtrados.add(l);
                }
            }
            break;
            
        case "Subconta":
            String subconta = (String) cboxConta.getSelectedItem();
            for (Lancamento l : todos) {
                if (l.getContas() != null && l.getContas().equals(subconta)) {
                    filtrados.add(l);
                }
            }
            break;
            
        case "Status":
            String status = (String) cboxStatus.getSelectedItem();
            for (Lancamento l : todos) {
                if (l.getStatus()!= null && l.getStatus().equals(status)) {
                    filtrados.add(l);
                }
            }
            break;

        default: 
            filtrados.addAll(todos);
    }
    
    preencherTabela(filtrados);
    
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       
    int linhaSelecionada = tblResumo.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this,
                "Selecione um lançamento para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Lancamento l = listaLancamentos.get(linhaSelecionada);
        
        int confirmacao = JOptionPane.showConfirmDialog(this,"Deseja realmente excluir o lançamento \"" + 
                l.getDescricao() + "\"?",
            "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
                boolean sucesso = LancamentoDAO.excluir(l);
            
            if (sucesso) {
            JOptionPane.showMessageDialog(this, "Lançamento excluído com sucesso!", "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            carregarTabela();
            if (receitaPanel != null) receitaPanel.carregarTabela();
            if (despesaPanel != null) despesaPanel.carregarTabela();

    }//GEN-LAST:event_btnExcluirActionPerformed
    }
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       cboxFiltro.setSelectedIndex(0);
       fDe.setText("");
       fAte.setText("");
       cboxConta.setSelectedIndex(0);
       cboxStatus.setSelectedIndex(0);
          carregarTabela();
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        int linhaSelecionada = tblResumo.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um lançamento para editar", "Aviso", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
            Lancamento l = LancamentoDAO.listar().get(linhaSelecionada);
            LancamentoPanel telaEditar = new LancamentoPanel(this, receitaPanel, despesaPanel, l);
            telaEditar.setVisible(true);
            
    }//GEN-LAST:event_btnEditarActionPerformed

    private boolean intervaloData(String dataOperacao, String de, String ate) {
   
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = sdf.parse(dataOperacao);

        if (!de.isEmpty() && data.before(sdf.parse(de))) {
            return false;
            
        } else if (!ate.isEmpty() && data.after(sdf.parse(ate))) {
            return false;
        }

        return true;

    } catch (ParseException e) {
        return false;
    }
    }
    
   private void totalizadores(List<Lancamento> lista) {
    
    double totReceitas = 0;
    double totDespesas = 0;
    double totReceber = 0;
    double totPagar = 0;

    if (lista != null) {
        for (Lancamento l : lista) {
            if (l.getTipo() == Movimento.RECEITA) {
                totReceitas += l.getValorOrig();
                if ("Não Liquidado".equals(l.getStatus())) {
                    totReceber += l.getValorOrig();
                }
            } else if (l.getTipo() == Movimento.DESPESA) {
                totDespesas += l.getValorOrig();
                if ("Não Liquidado".equals(l.getStatus())) {
                    totPagar += l.getValorOrig();
                }
            }
        }
    }

    double lucroApurado = totReceitas - totDespesas;

   // NumberFormat moeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    lblTotReceitas.setText(formatarMoeda(totReceitas));
    lblTotDespesas.setText(formatarMoeda(totDespesas));
    lblTotLucro.setText(formatarMoeda(lucroApurado));
    lblTotReceber.setText(formatarMoeda(totReceber));
    lblTotPagar.setText(formatarMoeda(totPagar));
    
}
   
// formatacao 
   
    private void formatacaoVisual() {
   
//cards 
    Temas.formatarCard(pnlReceita);
    Temas.formatarCard(pnlDespesas);
    Temas.formatarCard(pnlLucro);
    Temas.formatarCard(pnlReceber);
    Temas.formatarCard(pnlPagar);
   
   
//tabela
    Temas.formatarScroll(scrResumo);
    Temas.formatarTabela(tblResumo);
    
    }
    
    private void centralizarDadosTab() {
        
    javax.swing.table.DefaultTableCellRenderer centralizado = new javax.swing.table.DefaultTableCellRenderer();
    centralizado.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    for (int i = 0; i < tblResumo.getColumnCount(); i++) {
        tblResumo.getColumnModel().getColumn(i).setCellRenderer(centralizado);
        
        }   
    }
    //inputs
    private void formataCampos(javax.swing.JFormattedTextField campo, String mascara) {
    
    try {
        javax.swing.text.MaskFormatter formatador = new javax.swing.text.MaskFormatter(mascara);
        formatador.setPlaceholderCharacter(' ');
        formatador.install(campo);
        
    } catch (java.text.ParseException e) {
        e.printStackTrace();
    }
}

    private void mascaraData (javax.swing.JFormattedTextField data) {
        formataCampos(data, "##/##/####");
    }
   
    private String formatarMoeda(double valor) {
    
    NumberFormat formataMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
    return formataMoeda.format(valor);
}
    
    private String formatoNumerico(double valor) {
    
    NumberFormat formatoNumerico = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
    formatoNumerico.setMinimumFractionDigits(2);
    formatoNumerico.setMaximumFractionDigits(2);
    return formatoNumerico.format(valor);
}

    private void geraAcessbilidade() {

    btnLancamento.setMnemonic(KeyEvent.VK_N);
    btnLimpar.setMnemonic(KeyEvent.VK_L);
    btnEditar.setMnemonic(KeyEvent.VK_E);
    btnExcluir.setMnemonic(KeyEvent.VK_D);
    btnPesquisar.setMnemonic(KeyEvent.VK_P);
    
    
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLancamento;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cboxConta;
    private javax.swing.JComboBox<String> cboxFiltro;
    private javax.swing.JComboBox<String> cboxStatus;
    private javax.swing.JFormattedTextField fAte;
    private javax.swing.JFormattedTextField fDe;
    private javax.swing.JLabel lbAte;
    private javax.swing.JLabel lbCliente1;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JLabel lbPagar;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbRegistro;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotRegistro;
    private javax.swing.JLabel lblDespesas;
    private javax.swing.JLabel lblLucro;
    private javax.swing.JLabel lblReceber;
    private javax.swing.JLabel lblReceitas;
    private javax.swing.JLabel lblTotDespesas;
    private javax.swing.JLabel lblTotLucro;
    private javax.swing.JLabel lblTotPagar;
    private javax.swing.JLabel lblTotReceber;
    private javax.swing.JLabel lblTotReceitas;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlDespesas;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlLucro;
    private javax.swing.JPanel pnlPagar;
    private javax.swing.JPanel pnlReceber;
    private javax.swing.JPanel pnlReceita;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JScrollPane scrResumo;
    private javax.swing.JTable tblResumo;
    // End of variables declaration//GEN-END:variables
}
