
package view;

import dao.LancamentoDAO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Movimento;
import model.Lancamento;
import theme.Temas;

/**
 * Painel de filtro e impressão de dados.
 * 
 * @author Elane
 */
public class RelatorioPanel extends javax.swing.JPanel {
    
    private DefaultTableModel modelTabela;
   

public RelatorioPanel() {
        initComponents();
        formatacaoVisual();
        formatoData(fDe);
        formatoData(fAte);
       
    modelTabela = (DefaultTableModel) tblRelatorio.getModel();
    carregarTabela();
    geraAcessbilidade();
    Temas.addVersao(pnlInferior);
    
    
}   
   
    
public void carregarTabela() {
        
    preencherTabela(LancamentoDAO.listar());
    }

    private void preencherTabela(List<Lancamento> lista) {

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
    }
    
    
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

        if (lista != null) {
            for (Lancamento l : lista) {
                if (l.getTipo() == Movimento.RECEITA) {
                    totReceitas += l.getValorOrig();
                } else if (l.getTipo() == Movimento.DESPESA) {
                    totDespesas += l.getValorOrig();
                }
            }
        }

        double lucroApurado = totReceitas - totDespesas;

        lblTotReceitas.setText(formatarMoeda(totReceitas));
        lblTotDespesas.setText(formatarMoeda(totDespesas));
        lblTotLucro.setText(formatarMoeda(lucroApurado));
    }

    private String formatarMoeda(double valor) {
        java.text.NumberFormat formataMoeda = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
        return formataMoeda.format(valor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        lbPeriodo = new javax.swing.JLabel();
        lbDe = new javax.swing.JLabel();
        fDe = new javax.swing.JFormattedTextField();
        lbAte = new javax.swing.JLabel();
        fAte = new javax.swing.JFormattedTextField();
        btnFiltrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        pnlReceita = new javax.swing.JPanel();
        lblReceitas = new javax.swing.JLabel();
        lblTotReceitas = new javax.swing.JLabel();
        pnlDespesas = new javax.swing.JPanel();
        lblDespesas = new javax.swing.JLabel();
        lblTotDespesas = new javax.swing.JLabel();
        pnlLucro = new javax.swing.JPanel();
        lblLucro = new javax.swing.JLabel();
        lblTotLucro = new javax.swing.JLabel();
        lbMovimento = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();
        pnlTabela = new javax.swing.JPanel();
        scrRelatorio = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();

        setBackground(new java.awt.Color(234, 239, 255));
        setMaximumSize(null);

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Relatório Financeiro");

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
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        lbPeriodo.setBackground(new java.awt.Color(5, 4, 45));
        lbPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPeriodo.setForeground(new java.awt.Color(5, 4, 45));
        lbPeriodo.setText("Período:");

        lbDe.setText("De:");

        fDe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbAte.setText("Até:");

        fAte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnFiltrar.setBackground(new java.awt.Color(5, 4, 45));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_filtrar.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setToolTipText("Filtrar dados (ALT + F)");
        btnFiltrar.setActionCommand("");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(234, 239, 255));
        btnImprimir.setForeground(new java.awt.Color(5, 4, 45));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setToolTipText("Imprimir PDF");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(249, 249, 252));
        btnLimpar.setForeground(new java.awt.Color(5, 4, 45));
        btnLimpar.setText("↻ Limpar");
        btnLimpar.setToolTipText("Limpar (ALT + L)");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPeriodo)
                    .addGroup(pnlCardLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lbAte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDe)
                    .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAte)
                    .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));

        pnlReceita.setBackground(new java.awt.Color(228, 255, 237));
        pnlReceita.setPreferredSize(new java.awt.Dimension(180, 60));

        lblReceitas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblReceitas.setForeground(new java.awt.Color(3, 8, 255));
        lblReceitas.setText("Receitas do Período");

        lblTotReceitas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotReceitas.setForeground(new java.awt.Color(3, 8, 255));

        javax.swing.GroupLayout pnlReceitaLayout = new javax.swing.GroupLayout(pnlReceita);
        pnlReceita.setLayout(pnlReceitaLayout);
        pnlReceitaLayout.setHorizontalGroup(
            pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceitaLayout.createSequentialGroup()
                .addGroup(pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReceitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlReceitaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblTotReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlReceitaLayout.setVerticalGroup(
            pnlReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceitaLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblReceitas)
                .addGap(18, 18, 18)
                .addComponent(lblTotReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlDespesas.setBackground(new java.awt.Color(255, 240, 242));
        pnlDespesas.setPreferredSize(new java.awt.Dimension(180, 60));

        lblDespesas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDespesas.setForeground(new java.awt.Color(3, 8, 255));
        lblDespesas.setText("Despesas do Período");

        lblTotDespesas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotDespesas.setForeground(new java.awt.Color(3, 8, 255));

        javax.swing.GroupLayout pnlDespesasLayout = new javax.swing.GroupLayout(pnlDespesas);
        pnlDespesas.setLayout(pnlDespesasLayout);
        pnlDespesasLayout.setHorizontalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addGroup(pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDespesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDespesasLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTotDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlDespesasLayout.setVerticalGroup(
            pnlDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDespesasLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblDespesas)
                .addGap(18, 18, 18)
                .addComponent(lblTotDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pnlLucro.setBackground(new java.awt.Color(222, 240, 252));
        pnlLucro.setPreferredSize(new java.awt.Dimension(180, 60));

        lblLucro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLucro.setForeground(new java.awt.Color(3, 8, 255));
        lblLucro.setText("Lucro  Apurado do Período");

        lblTotLucro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotLucro.setForeground(new java.awt.Color(3, 8, 255));

        javax.swing.GroupLayout pnlLucroLayout = new javax.swing.GroupLayout(pnlLucro);
        pnlLucro.setLayout(pnlLucroLayout);
        pnlLucroLayout.setHorizontalGroup(
            pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLucroLayout.createSequentialGroup()
                .addGroup(pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLucroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLucro))
                    .addGroup(pnlLucroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTotLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pnlLucroLayout.setVerticalGroup(
            pnlLucroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLucroLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblLucro)
                .addGap(18, 18, 18)
                .addComponent(lblTotLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 268, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlDespesas, pnlLucro, pnlReceita});

        lbMovimento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMovimento.setForeground(new java.awt.Color(5, 4, 45));
        lbMovimento.setText("Movimentações do Período");

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

        pnlTabela.setPreferredSize(new java.awt.Dimension(452, 412));
        pnlTabela.setLayout(new java.awt.BorderLayout());

        scrRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        scrRelatorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrRelatorio.setMinimumSize(new java.awt.Dimension(10, 10));

        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Movimento", "Data", "Setor", "SubConta", "Valor", "Descrição", "Cliente/Fornecedor", "Forma de Pgto/Rec.", "Data de Venc.", "Status", "Liquidado em", "Valor Rec./Pago", "Juros", "Multa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRelatorio.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblRelatorio.setMinimumSize(new java.awt.Dimension(10, 10));
        tblRelatorio.setOpaque(false);
        scrRelatorio.setViewportView(tblRelatorio);
        if (tblRelatorio.getColumnModel().getColumnCount() > 0) {
            tblRelatorio.getColumnModel().getColumn(0).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(0).setMaxWidth(150);
            tblRelatorio.getColumnModel().getColumn(1).setMinWidth(80);
            tblRelatorio.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblRelatorio.getColumnModel().getColumn(1).setMaxWidth(80);
            tblRelatorio.getColumnModel().getColumn(2).setMinWidth(200);
            tblRelatorio.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblRelatorio.getColumnModel().getColumn(2).setMaxWidth(200);
            tblRelatorio.getColumnModel().getColumn(3).setMinWidth(200);
            tblRelatorio.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblRelatorio.getColumnModel().getColumn(3).setMaxWidth(200);
            tblRelatorio.getColumnModel().getColumn(4).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(4).setMaxWidth(150);
            tblRelatorio.getColumnModel().getColumn(5).setMinWidth(250);
            tblRelatorio.getColumnModel().getColumn(5).setPreferredWidth(250);
            tblRelatorio.getColumnModel().getColumn(5).setMaxWidth(250);
            tblRelatorio.getColumnModel().getColumn(6).setMinWidth(200);
            tblRelatorio.getColumnModel().getColumn(6).setPreferredWidth(200);
            tblRelatorio.getColumnModel().getColumn(6).setMaxWidth(200);
            tblRelatorio.getColumnModel().getColumn(7).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(7).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(7).setMaxWidth(150);
            tblRelatorio.getColumnModel().getColumn(8).setMinWidth(80);
            tblRelatorio.getColumnModel().getColumn(8).setPreferredWidth(80);
            tblRelatorio.getColumnModel().getColumn(8).setMaxWidth(80);
            tblRelatorio.getColumnModel().getColumn(9).setMinWidth(100);
            tblRelatorio.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblRelatorio.getColumnModel().getColumn(9).setMaxWidth(100);
            tblRelatorio.getColumnModel().getColumn(10).setMinWidth(80);
            tblRelatorio.getColumnModel().getColumn(10).setPreferredWidth(80);
            tblRelatorio.getColumnModel().getColumn(10).setMaxWidth(80);
            tblRelatorio.getColumnModel().getColumn(11).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(11).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(11).setMaxWidth(150);
            tblRelatorio.getColumnModel().getColumn(12).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(12).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(12).setMaxWidth(150);
            tblRelatorio.getColumnModel().getColumn(13).setMinWidth(150);
            tblRelatorio.getColumnModel().getColumn(13).setPreferredWidth(150);
            tblRelatorio.getColumnModel().getColumn(13).setMaxWidth(150);
        }

        pnlTabela.add(scrRelatorio, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMovimento)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMovimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 303, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        
        String de = fDe.getText().trim();
        String ate = fAte.getText().trim();

        if (!de.isEmpty() && !de.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Informe uma data inicial válida (dd/mm/aaaa).");
            fDe.requestFocusInWindow();
            return;
        }

        if (!ate.isEmpty() && !ate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Informe uma data final válida (dd/mm/aaaa).");
            fAte.requestFocusInWindow();
            return;
        }

        List<Lancamento> filtrados = new ArrayList<>();
        for (Lancamento l : LancamentoDAO.listar()) {
            if (intervaloData(l.getDataOperacao(), de, ate)) {
                filtrados.add(l);
            }
        }
       preencherTabela(filtrados);
      
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        fDe.setText("");
        fAte.setText("");
        carregarTabela();
    
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");

    }//GEN-LAST:event_btnImprimirActionPerformed

    //formatacao
    
    private void formatacaoVisual () {
       
    //tabela
    Temas.formatarScroll(scrRelatorio);
    Temas.formatarTabela(tblRelatorio);   
     
    }
    
    //inputs
    private void formatoData(javax.swing.JFormattedTextField campo) {
        
        try {
            javax.swing.text.MaskFormatter formatoData = new javax.swing.text.MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter(' ');
            formatoData.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
    
    private String formatoNumerico(double valor) {
    
    java.text.NumberFormat formatoNumerico = java.text.NumberFormat.getNumberInstance(new java.util.Locale("pt", "BR"));
    formatoNumerico.setMinimumFractionDigits(2);
    formatoNumerico.setMaximumFractionDigits(2);
    return formatoNumerico.format(valor);
}
     
    private void geraAcessbilidade() {

    btnFiltrar.setMnemonic(KeyEvent.VK_F);
    btnLimpar.setMnemonic(KeyEvent.VK_L);   
    
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JFormattedTextField fAte;
    private javax.swing.JFormattedTextField fDe;
    private javax.swing.JLabel lbAte;
    private javax.swing.JLabel lbDe;
    private javax.swing.JLabel lbMovimento;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lblDespesas;
    private javax.swing.JLabel lblLucro;
    private javax.swing.JLabel lblReceitas;
    private javax.swing.JLabel lblTotDespesas;
    private javax.swing.JLabel lblTotLucro;
    private javax.swing.JLabel lblTotReceitas;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlDespesas;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlLucro;
    private javax.swing.JPanel pnlReceita;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JScrollPane scrRelatorio;
    private javax.swing.JTable tblRelatorio;
    // End of variables declaration//GEN-END:variables
}