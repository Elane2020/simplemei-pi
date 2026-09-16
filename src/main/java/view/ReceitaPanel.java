
package view;

import java.util.List;
import java.util.ArrayList;
import model.Lancamento;
import model.Movimento;
import dao.LancamentoDAO;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import theme.Temas;


public class ReceitaPanel extends javax.swing.JPanel {

   private ResumoPanel resumoPanel;
   private DespesaPanel despesaPanel;
   private javax.swing.table.DefaultTableModel modelTabela;
   private List<Lancamento> listaLancamentos;
   
public void exibePanel (ResumoPanel resumoPanel, DespesaPanel despesaPanel){
    this.resumoPanel = resumoPanel;
    this.despesaPanel = despesaPanel;
 
}
    public ReceitaPanel() {
        initComponents();
        formatacaoVisual();
        aplicarMascaraData(fDe);
        aplicarMascaraData(fAte);    
      
        modelTabela = (DefaultTableModel) tblReceita.getModel();
        carregarTabela();
        
        geraAcessbilidade();
        Temas.addVersao(pnlInferior);
        
    }
    
        
public void carregarTabela() {
        carregarClientes();
        preencherTabela();
}
    
    private void preencherTabela() {
    
    List<Lancamento> todos = LancamentoDAO.listar();
    List<Lancamento> receitas = new ArrayList<>();
    for (Lancamento l : todos) {
        if (l.getTipo() == Movimento.RECEITA) {
            receitas.add(l);
        }
    }
    preencherTabela(receitas);
    
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
    
     private void carregarClientes() {
        Object selecionado = cboxCliente.getSelectedItem();

        javax.swing.DefaultComboBoxModel<String> modelo = new javax.swing.DefaultComboBoxModel<>();
        modelo.addElement("Todos");
        for (model.Cliente c : dao.ClienteDAO.listar()) {
            modelo.addElement(c.getNomeCliente());
        }
        cboxCliente.setModel(modelo);

        if (selecionado != null && modelo.getIndexOf(selecionado) != -1) {
            cboxCliente.setSelectedItem(selecionado);
        } else {
            cboxCliente.setSelectedIndex(0);
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
        lbCliente = new javax.swing.JLabel();
        cboxCliente = new javax.swing.JComboBox<>();
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
        pnlRecebido = new javax.swing.JPanel();
        lbRecebido = new javax.swing.JLabel();
        lbTotRecebido = new javax.swing.JLabel();
        pnlReceber = new javax.swing.JPanel();
        lbReceber = new javax.swing.JLabel();
        lbTotReceber = new javax.swing.JLabel();
        pnlAtraso = new javax.swing.JPanel();
        lbAtraso = new javax.swing.JLabel();
        lbTotAtraso = new javax.swing.JLabel();
        pnlTotal = new javax.swing.JPanel();
        lbReceita = new javax.swing.JLabel();
        lbTotReceita = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();
        scrReceita = new javax.swing.JScrollPane();
        tblReceita = new javax.swing.JTable();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnlSuperior.setPreferredSize(new java.awt.Dimension(200, 25));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Contas a Receber");
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

        cboxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Período", "Cliente", "Status", " " }));
        cboxFiltro.setToolTipText("Escolha um tipo");

        lbAte.setText("até");

        lbPeriodo.setText("Período");

        lbCliente.setText("Cliente");

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
        btnNovo.setToolTipText("Novo lançamento (ALT + N)");
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
                                    .addComponent(cboxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCliente)))
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
                        .addContainerGap(248, Short.MAX_VALUE))
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
                    .addComponent(lbCliente)
                    .addComponent(lbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbAte)
                    .addComponent(fDe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fAte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlRecebido.setBackground(new java.awt.Color(249, 249, 252));
        pnlRecebido.setPreferredSize(new java.awt.Dimension(210, 90));

        lbRecebido.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbRecebido.setForeground(new java.awt.Color(0, 204, 51));
        lbRecebido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_porquinho.png"))); // NOI18N
        lbRecebido.setText("Recebido");

        lbTotRecebido.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotRecebido.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlRecebidoLayout = new javax.swing.GroupLayout(pnlRecebido);
        pnlRecebido.setLayout(pnlRecebidoLayout);
        pnlRecebidoLayout.setHorizontalGroup(
            pnlRecebidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecebidoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(pnlRecebidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlRecebidoLayout.setVerticalGroup(
            pnlRecebidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecebidoLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lbRecebido)
                .addGap(14, 14, 14)
                .addComponent(lbTotRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE))
        );

        pnlReceber.setBackground(new java.awt.Color(249, 249, 252));
        pnlReceber.setPreferredSize(new java.awt.Dimension(210, 90));

        lbReceber.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbReceber.setForeground(new java.awt.Color(51, 0, 255));
        lbReceber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_recebimento.png"))); // NOI18N
        lbReceber.setText("A Receber");

        lbTotReceber.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotReceber.setForeground(new java.awt.Color(5, 4, 45));

        javax.swing.GroupLayout pnlReceberLayout = new javax.swing.GroupLayout(pnlReceber);
        pnlReceber.setLayout(pnlReceberLayout);
        pnlReceberLayout.setHorizontalGroup(
            pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceberLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotReceber, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlReceberLayout.setVerticalGroup(
            pnlReceberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceberLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(lbReceber)
                .addGap(14, 14, 14)
                .addComponent(lbTotReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 27, Short.MAX_VALUE))
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
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(pnlAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotAtraso, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlAtrasoLayout.setVerticalGroup(
            pnlAtrasoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAtrasoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAtraso)
                .addGap(14, 14, 14)
                .addComponent(lbTotAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 31, Short.MAX_VALUE))
        );

        pnlTotal.setBackground(new java.awt.Color(249, 249, 252));
        pnlTotal.setPreferredSize(new java.awt.Dimension(210, 90));

        lbReceita.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbReceita.setForeground(new java.awt.Color(255, 204, 51));
        lbReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_moeda.png"))); // NOI18N
        lbReceita.setText("Total de Receitas");

        lbTotReceita.setBackground(new java.awt.Color(5, 4, 45));
        lbTotReceita.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbTotReceita.setForeground(new java.awt.Color(5, 4, 45));
        lbTotReceita.setToolTipText("");

        javax.swing.GroupLayout pnlTotalLayout = new javax.swing.GroupLayout(pnlTotal);
        pnlTotal.setLayout(pnlTotalLayout);
        pnlTotalLayout.setHorizontalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTotReceita, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnlTotalLayout.setVerticalGroup(
            pnlTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbReceita)
                .addGap(14, 14, 14)
                .addComponent(lbTotReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCardLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pnlAtraso, pnlReceber, pnlRecebido, pnlTotal});

        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlReceber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAtraso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRecebido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnlCardLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlAtraso, pnlReceber, pnlRecebido, pnlTotal});

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

        scrReceita.setBackground(new java.awt.Color(249, 249, 252));
        scrReceita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrReceita.setMaximumSize(null);
        scrReceita.setMinimumSize(new java.awt.Dimension(10, 10));

        tblReceita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Movimento", "Data", "Setor", "Subconta", "Valor", "Descrição", "Cliente", "Forma de Rec.", "Data de Venc.", "Status", "Liquidado em", "Valor Rec.", "Juros", "Desconto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReceita.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblReceita.setMinimumSize(new java.awt.Dimension(10, 10));
        tblReceita.setOpaque(false);
        scrReceita.setViewportView(tblReceita);
        if (tblReceita.getColumnModel().getColumnCount() > 0) {
            tblReceita.getColumnModel().getColumn(0).setMinWidth(150);
            tblReceita.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblReceita.getColumnModel().getColumn(0).setMaxWidth(150);
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
                    .addComponent(scrReceita, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(scrReceita, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
    
    String filtro = (String) cboxFiltro.getSelectedItem();

    List<Lancamento> todos = LancamentoDAO.listar();
    List<Lancamento> receitas = new ArrayList<>();
    for (Lancamento l : todos) {
        if (l.getTipo() == Movimento.RECEITA) {
            receitas.add(l);
        }
    }

    List<Lancamento> filtrados = new ArrayList<>();

    switch (filtro) {
        case "Período":
            String de = fDe.getText().trim();
            String ate = fAte.getText().trim();
            for (Lancamento l : receitas) {
                if (intervaloData(l.getDataOperacao(), de, ate)) {
                    filtrados.add(l);
                }
            }
            break;

        case "Cliente":
            String cliente = (String) cboxCliente.getSelectedItem();
            for (Lancamento l : receitas) {
                if (l.getClienteFornecedor()!= null && l.getClienteFornecedor().equals(cliente)) {
                    filtrados.add(l);
                }
            }
            break;

        case "Status":
            String status = (String) cboxStatus.getSelectedItem();
            for (Lancamento l : receitas) {
                if (l.getStatus() != null && l.getStatus().equals(status)) {
                    filtrados.add(l);
                }
            }
            break;

        default:
            filtrados.addAll(receitas);
    }

    preencherTabela(filtrados);                                          

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       
    int linhaSelecionada = tblReceita.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this,
            "Selecione um lançamento para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Lancamento l = listaLancamentos.get(linhaSelecionada);
    
    int confirmacao = JOptionPane.showConfirmDialog(this,"Deseja excluir o lançamento \"" + l.getDescricao()+ "\"?",
        "Confirmar exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

    if (confirmacao == JOptionPane.YES_OPTION) {
        boolean sucesso = LancamentoDAO.excluir(l);
        
    
        if (sucesso) {
             JOptionPane.showMessageDialog(this, "Lançamento excluído com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        }
              
        carregarTabela();
        if (resumoPanel != null) resumoPanel.carregarTabela();
        if (despesaPanel != null) despesaPanel.carregarTabela();
        
          }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
      
        LancamentoPanel telaLancamento = new LancamentoPanel(resumoPanel,this, despesaPanel);
        telaLancamento.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
    int linhaSelecionada = tblReceita.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(this,
            "Selecione um lançamento para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Lancamento l = listaLancamentos.get(linhaSelecionada);
    LancamentoPanel telaLancamento = new LancamentoPanel(resumoPanel, this, despesaPanel, l);
    telaLancamento.setVisible(true);

            
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       cboxFiltro.setSelectedIndex(0);
       fDe.setText("");
       fAte.setText("");
       cboxCliente.setSelectedIndex(0);
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
   
    double recTotal = 0;
    double totRecebido = 0;
    double totReceber = 0;
    double totAtraso = 0;

    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
    java.util.Date hoje = new java.util.Date();

    if (lista != null) {
        for (Lancamento l : lista) {
            recTotal += l.getValorOrig();

            if ("Liquidado".equals(l.getStatus())) {
                totRecebido += l.getValorLiquidado();
            } else {
                try {
                    java.util.Date vencimento = sdf.parse(l.getDataVencimento());
                    if (vencimento.before(hoje)) {
                        totAtraso += l.getValorOrig();
                    } else {
                        totReceber += l.getValorOrig();
                    }
                } catch (java.text.ParseException e) {
                    totReceber += l.getValorOrig();
                }
            }
        }
    }

    lbTotReceita.setText(formatarMoeda(recTotal));
    lbTotRecebido.setText(formatarMoeda(totRecebido));
    lbTotReceber.setText(formatarMoeda(totReceber));
    lbTotAtraso.setText(formatarMoeda(totAtraso));
}

    // formatacao
    
    private void formatacaoVisual() {
        
        Temas.formatarCard(pnlReceber);
        Temas.formatarCard(pnlRecebido);
        Temas.formatarCard(pnlAtraso);
        Temas.formatarCard(pnlTotal);
        
        Temas.formatarTabela(tblReceita);
                   
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
    private javax.swing.JComboBox<String> cboxCliente;
    private javax.swing.JComboBox<String> cboxFiltro;
    private javax.swing.JComboBox<String> cboxStatus;
    private javax.swing.JFormattedTextField fAte;
    private javax.swing.JFormattedTextField fDe;
    private javax.swing.JLabel lbAte;
    private javax.swing.JLabel lbAtraso;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbFiltrar;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbReceber;
    private javax.swing.JLabel lbRecebido;
    private javax.swing.JLabel lbReceita;
    private javax.swing.JLabel lbRegistro;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTotAtraso;
    private javax.swing.JLabel lbTotReceber;
    private javax.swing.JLabel lbTotRecebido;
    private javax.swing.JLabel lbTotReceita;
    private javax.swing.JLabel lbTotRegistro;
    private javax.swing.JPanel pnlAtraso;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlReceber;
    private javax.swing.JPanel pnlRecebido;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTotal;
    private javax.swing.JScrollPane scrReceita;
    private javax.swing.JTable tblReceita;
    // End of variables declaration//GEN-END:variables
}
