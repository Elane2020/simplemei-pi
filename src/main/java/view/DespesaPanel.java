
package view;

import dao.LancamentoDAO;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Lancamento;
import model.Movimento;
import theme.Temas;


public class DespesaPanel extends javax.swing.JPanel {

   private ResumoPanel resumoPanel;
   private ReceitaPanel receitaPanel;
   private javax.swing.table.DefaultTableModel modelTabela;
   private List<Lancamento> listaLancamentos;
   
public void exibePanel (ResumoPanel resumoPanel, ReceitaPanel receitaPanel){
    this.resumoPanel = resumoPanel;
    this.receitaPanel = receitaPanel;
 
}
public DespesaPanel() {
        initComponents();
        formatacaoVisual();
        aplicarMascaraData(fDe);
        aplicarMascaraData(fAte);
        modelTabela = (DefaultTableModel) tblDespesas.getModel();
        carregarTabela();
        geraAcessbilidade();
        Temas.addVersao(pnlInferior);
      
    }
    
public void carregarTabela() {
    carregarFornecedores();
    preencherTabela();
}

    private void preencherTabela() {
        
    List<Lancamento> todos = LancamentoDAO.listar();
    List<Lancamento> despesas = new ArrayList<>();

    for (Lancamento l : todos) {
        if (l.getTipo() == Movimento.DESPESA) {
            despesas.add(l);
        }
    }
        preencherTabela(despesas);
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
    
    private void carregarFornecedores() {
        
        Object selecionado = cboxFornecedor.getSelectedItem();

        javax.swing.DefaultComboBoxModel<String> modelo = new javax.swing.DefaultComboBoxModel<>();
        modelo.addElement("Todos");
        for (model.Fornecedor f : dao.FornecedorDAO.listar()) {
            modelo.addElement(f.getRazaoSocial());
        }
        cboxFornecedor.setModel(modelo);

        if (selecionado != null && modelo.getIndexOf(selecionado) != -1) {
            cboxFornecedor.setSelectedItem(selecionado);
        } else {
            cboxFornecedor.setSelectedIndex(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        lbFiltrar = new javax.swing.JLabel();
        cboxFiltro = new javax.swing.JComboBox<>();
        fDe = new javax.swing.JFormattedTextField();
        lbAte = new javax.swing.JLabel();
        fAte = new javax.swing.JFormattedTextField();
        lbPeriodo = new javax.swing.JLabel();
        lbFornecedor = new javax.swing.JLabel();
        cboxFornecedor = new javax.swing.JComboBox<>();
        lbStatus = new javax.swing.JLabel();
        cboxStatus = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lbRegistro = new javax.swing.JLabel();
        lbTotRegistro = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        pnlPagas = new javax.swing.JPanel();
        lbPagas = new javax.swing.JLabel();
        lbTotPagas = new javax.swing.JLabel();
        pnlPagar = new javax.swing.JPanel();
        lbPagar = new javax.swing.JLabel();
        lbTotPagar = new javax.swing.JLabel();
        pnlAtraso = new javax.swing.JPanel();
        lbAtraso = new javax.swing.JLabel();
        lbTotAtraso = new javax.swing.JLabel();
        pnlTotal = new javax.swing.JPanel();
        lbDespesas = new javax.swing.JLabel();
        lbTotDespesas = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();
        scrDespesas = new javax.swing.JScrollPane();
        tblDespesas = new javax.swing.JTable();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(200, 25));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Contas a Pagar");
        lbTitulo.setPreferredSize(new java.awt.Dimension(61, 22));

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
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));

        lbFiltrar.setText("Filtrar por:");

        cboxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Período", "Fornecedor", "Status", " " }));
        cboxFiltro.setToolTipText("Escolha um tipo");

        lbAte.setText("até");

        lbPeriodo.setText("Período");

        lbFornecedor.setText("Fornecedor");

        lbStatus.setText("Status");

        cboxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Liquidado", "Não Liquidado" }));

        btnPesquisar.setBackground(new java.awt.Color(53, 106, 227));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setToolTipText("Pesquisar (ALT + P)");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(224, 224, 247));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_esfregao.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("Limpar (ALT + L)");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(5, 4, 45));
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("+ Novo Registro");
        btnNovo.setToolTipText("Novo Lançamento (ALT + N)");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(224, 224, 247));
        btnEdit.setForeground(new java.awt.Color(5, 4, 45));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_editar.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setToolTipText("Editar (ALT + E)");
        btnEdit.setIconTextGap(5);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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

        lbRegistro.setText("Total de registros:");

        lbTotRegistro.setBackground(new java.awt.Color(5, 4, 45));
        lbTotRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotRegistro.setText("0");

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFiltrar, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(10, 10, 10)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPeriodo)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbAte)))
                        .addGap(10, 10, 10)
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFornecedor)))
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlButtonsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStatus)
                            .addGroup(pnlButtonsLayout.createSequentialGroup()
                                .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fAte, fDe});

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEdit, btnExcluir});

        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFiltrar)
                    .addComponent(lbPeriodo)
                    .addComponent(lbFornecedor)
                    .addComponent(lbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbAte)
                    .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbRegistro)
                    .addComponent(lbTotRegistro)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        pnlPagas.setBackground(new java.awt.Color(249, 249, 252));
        pnlPagas.setPreferredSize(new java.awt.Dimension(210, 90));

        lbPagas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbPagas.setForeground(new java.awt.Color(0, 204, 51));
        lbPagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_porquinho.png"))); // NOI18N
        lbPagas.setText("Pagas");

        lbTotPagas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotPagas.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlPagasLayout = new javax.swing.GroupLayout(pnlPagas);
        pnlPagas.setLayout(pnlPagasLayout);
        pnlPagasLayout.setHorizontalGroup(
            pnlPagasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagasLayout.createSequentialGroup()
                .addGap(20, 27, Short.MAX_VALUE)
                .addGroup(pnlPagasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnlPagasLayout.setVerticalGroup(
            pnlPagasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagasLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbPagas)
                .addGap(14, 14, 14)
                .addComponent(lbTotPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE))
        );

        pnlPagar.setBackground(new java.awt.Color(249, 249, 252));
        pnlPagar.setPreferredSize(new java.awt.Dimension(210, 90));

        lbPagar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbPagar.setForeground(new java.awt.Color(51, 0, 255));
        lbPagar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_recebimento.png"))); // NOI18N
        lbPagar.setText("A Pagar");

        lbTotPagar.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotPagar.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlPagarLayout = new javax.swing.GroupLayout(pnlPagar);
        pnlPagar.setLayout(pnlPagarLayout);
        pnlPagarLayout.setHorizontalGroup(
            pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagarLayout.createSequentialGroup()
                .addGap(20, 39, Short.MAX_VALUE)
                .addGroup(pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotPagar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(20, 38, Short.MAX_VALUE))
        );
        pnlPagarLayout.setVerticalGroup(
            pnlPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagarLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbPagar)
                .addGap(14, 14, 14)
                .addComponent(lbTotPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE))
        );

        pnlAtraso.setBackground(new java.awt.Color(249, 249, 252));
        pnlAtraso.setPreferredSize(new java.awt.Dimension(210, 90));

        lbAtraso.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbAtraso.setForeground(new java.awt.Color(255, 0, 0));
        lbAtraso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_atraso.png"))); // NOI18N
        lbAtraso.setText("Em Atraso");

        lbTotAtraso.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotAtraso.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlAtrasoLayout = new javax.swing.GroupLayout(pnlAtraso);
        pnlAtraso.setLayout(pnlAtrasoLayout);
        pnlAtrasoLayout.setHorizontalGroup(
            pnlAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtrasoLayout.createSequentialGroup()
                .addGap(20, 37, Short.MAX_VALUE)
                .addGroup(pnlAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotAtraso, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(20, 37, Short.MAX_VALUE))
        );
        pnlAtrasoLayout.setVerticalGroup(
            pnlAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtrasoLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbAtraso)
                .addGap(14, 14, 14)
                .addComponent(lbTotAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE))
        );

        pnlTotal.setBackground(new java.awt.Color(249, 249, 252));
        pnlTotal.setPreferredSize(new java.awt.Dimension(210, 90));

        lbDespesas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbDespesas.setForeground(new java.awt.Color(255, 204, 51));
        lbDespesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_moeda.png"))); // NOI18N
        lbDespesas.setText("Total de Despesas");

        lbTotDespesas.setBackground(new java.awt.Color(5, 4, 45));
        lbTotDespesas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotDespesas.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addGap(20, 37, Short.MAX_VALUE)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(20, 37, Short.MAX_VALUE))
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbDespesas)
                .addGap(14, 14, 14)
                .addComponent(lbTotDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCardLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pnlAtraso, pnlPagar, pnlPagas, pnlTotal});

        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAtraso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPagas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnlCardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlAtraso, pnlPagar, pnlPagas, pnlTotal});

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

        scrDespesas.setBackground(new java.awt.Color(249, 249, 252));
        scrDespesas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrDespesas.setMaximumSize(null);
        scrDespesas.setMinimumSize(new java.awt.Dimension(10, 10));

        tblDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo de Movimento", "Data", "Setor", "Subconta", "Valor", "Descrição", "Fornecedor", "Forma de Pgto.", "Data de Venc.", "Status", "Liquidado em", "Valor Pago", "Juros", "Desconto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDespesas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDespesas.setMinimumSize(new java.awt.Dimension(10, 10));
        tblDespesas.setOpaque(false);
        scrDespesas.setViewportView(tblDespesas);
        if (tblDespesas.getColumnModel().getColumnCount() > 0) {
            tblDespesas.getColumnModel().getColumn(0).setMinWidth(150);
            tblDespesas.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblDespesas.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrDespesas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scrDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
    String filtro = (String) cboxFiltro.getSelectedItem();

    List<Lancamento> todos = LancamentoDAO.listar();
    List<Lancamento> despesas = new ArrayList<>();
    for (Lancamento l : todos) {
        if (l.getTipo() == Movimento.DESPESA) {
            despesas.add(l);
        }
    }

    List<Lancamento> filtrados = new ArrayList<>();

    switch (filtro) {
        case "Período":
            String de = fDe.getText().trim();
            String ate = fAte.getText().trim();
            for (Lancamento l : despesas) {
                if (intervaloData(l.getDataOperacao(), de, ate)) {
                    filtrados.add(l);
                }
            }
            break;

        case "Fornecedor":
            String fornecedor = (String) cboxFornecedor.getSelectedItem();
            for (Lancamento l : despesas) {
                if (l.getClienteFornecedor() != null && l.getClienteFornecedor().equals(fornecedor)) {
                    filtrados.add(l);
                }
            }
            break;

        case "Status":
            String status = (String) cboxStatus.getSelectedItem();
            for (Lancamento l : despesas) {
                if (l.getStatus() != null && l.getStatus().equals(status)) {
                    filtrados.add(l);
                }
            }
            break;

        default:
            filtrados.addAll(despesas);
    }

    preencherTabela(filtrados);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
    int linhaSelecionada = tblDespesas.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this,
            "Selecione um lançamento para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Lancamento l = listaLancamentos.get(linhaSelecionada);

    int confirmacao = JOptionPane.showConfirmDialog(this,
        "Deseja excluir o lançamento \"" + l.getDescricao() + "\"?", "Confirmar exclusão",
        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

    if (confirmacao == JOptionPane.YES_OPTION) {
         boolean sucesso = LancamentoDAO.excluir(l);

        JOptionPane.showMessageDialog(this, "Lançamento excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        carregarTabela();
        if (resumoPanel != null) resumoPanel.carregarTabela();
        if (receitaPanel != null) receitaPanel.carregarTabela();
    }
    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
      
       LancamentoPanel telaLancamento = new LancamentoPanel(resumoPanel, receitaPanel, this);
       telaLancamento.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
    int linhaSelecionada = tblDespesas.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this,
            "Selecione um lançamento para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Lancamento l = listaLancamentos.get(linhaSelecionada);
    LancamentoPanel telaLancamento = new LancamentoPanel(resumoPanel, receitaPanel, this, l);
    telaLancamento.setVisible(true);
    
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       cboxFiltro.setSelectedIndex(0);
       fDe.setText("");
       fAte.setText("");
       cboxFornecedor.setSelectedIndex(0);
       cboxStatus.setSelectedIndex(0);
       
          carregarTabela();
    }//GEN-LAST:event_btnLimparActionPerformed
    
    
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
    
    double despTotal = 0;
    double totPago = 0;
    double totPagar = 0;
    double totAtraso = 0;

    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    java.util.Date hoje = new java.util.Date();

    if (lista != null) {
        for (Lancamento l : lista) {
            despTotal += l.getValorOrig();

            if ("Liquidado".equals(l.getStatus())) {
                totPago += l.getValorLiquidado();
            } else {
                try {
                    java.util.Date vencimento = sdf.parse(l.getDataVencimento());
                    if (vencimento.before(hoje)) {
                        totAtraso += l.getValorOrig();
                    } else {
                        totPagar += l.getValorOrig();
                    }
                } catch (java.text.ParseException e) {
                    totPagar += l.getValorOrig();
                }
            }
        }
    }

    lbTotDespesas.setText(formatarMoeda(despTotal));
    lbTotPagas.setText(formatarMoeda(totPago));
    lbTotPagar.setText(formatarMoeda(totPagar));
    lbTotAtraso.setText(formatarMoeda(totAtraso));
}
    

// formatacao
    
    private void formatacaoVisual() {
        
        Temas.formatarCard(pnlPagar);
        Temas.formatarCard(pnlPagas);
        Temas.formatarCard(pnlAtraso);
        Temas.formatarCard(pnlTotal);
        
        Temas.formatarTabela(tblDespesas);
                   
    }
    
    
    //inputs
    private void aplicarMascaraData(javax.swing.JFormattedTextField campo) {
        try {
            javax.swing.text.MaskFormatter formatoData = new javax.swing.text.MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter(' ');
            formatoData.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
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

    btnNovo.setMnemonic(KeyEvent.VK_N);
    btnLimpar.setMnemonic(KeyEvent.VK_L);
    btnEdit.setMnemonic(KeyEvent.VK_E);
    btnExcluir.setMnemonic(KeyEvent.VK_D);
    btnPesquisar.setMnemonic(KeyEvent.VK_P);
    
    
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cboxFiltro;
    private javax.swing.JComboBox<String> cboxFornecedor;
    private javax.swing.JComboBox<String> cboxStatus;
    private javax.swing.JFormattedTextField fAte;
    private javax.swing.JFormattedTextField fDe;
    private javax.swing.JLabel lbAte;
    private javax.swing.JLabel lbAtraso;
    private javax.swing.JLabel lbDespesas;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JLabel lbFornecedor;
    private javax.swing.JLabel lbPagar;
    private javax.swing.JLabel lbPagas;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbRegistro;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotAtraso;
    private javax.swing.JLabel lbTotDespesas;
    private javax.swing.JLabel lbTotPagar;
    private javax.swing.JLabel lbTotPagas;
    private javax.swing.JLabel lbTotRegistro;
    private javax.swing.JPanel pnlAtraso;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlPagar;
    private javax.swing.JPanel pnlPagas;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JScrollPane scrDespesas;
    private javax.swing.JTable tblDespesas;
    // End of variables declaration//GEN-END:variables
}
