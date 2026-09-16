package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import theme.Temas;

public class CadastroPanel extends javax.swing.JPanel {
  
    public CadastroPanel() {
      
      initComponents();
      formatacaoVisual();
      carregarTabelaClientes();
      carregarTabelaFornecedor();
      
      geraAcessbilidade();
      Temas.addVersao(pnlInferior);
      
    }

    public void carregarTabelaClientes() {
        
        DefaultTableModel tableModel = (DefaultTableModel) tblClientes.getModel();
        tableModel.setRowCount(0);

        for (model.Cliente c : dao.ClienteDAO.listar()) {
            tableModel.addRow(new Object[]{
                c.getNomeCliente(),
                c.getNumCNPJ(),
                c.getNumIE(),
                c.getEndereco().getLogradouro(),
                c.getEndereco().getBairro(),
                c.getEndereco().getCidade(),
                c.getEndereco().getEstado(),
                c.getTelefone(),
                c.getEmail(),
                c.getResponsavel()
            });
        }
    }

    public void carregarTabelaFornecedor() {
        DefaultTableModel tableModel = (DefaultTableModel) tblFornecedor.getModel();
        tableModel.setRowCount(0);

        for (model.Fornecedor f : dao.FornecedorDAO.listar()) {
            tableModel.addRow(new Object[]{
                f.getRazaoSocial(),
                f.getNumCNPJ(),
                f.getNumIE(),
                f.getEndereco().getBairro(),
                f.getEndereco().getLogradouro(),
                f.getEndereco().getCidade(),
                f.getEndereco().getEstado(),
                f.getTelefone(),
                f.getEmail(),
                f.getResponsavel()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        tbbCadastro = new javax.swing.JTabbedPane();
        pnlCliente = new javax.swing.JPanel();
        txtBuscaCliente = new javax.swing.JTextField();
        btnCliente = new javax.swing.JButton();
        scrTblCliente = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        pnlFornecedor = new javax.swing.JPanel();
        txtBuscaForn = new javax.swing.JTextField();
        btnFornecedor = new javax.swing.JButton();
        scrTblFor = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(234, 239, 255));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(734, 512));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Cadastros");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        tbbCadastro.setBackground(new java.awt.Color(255, 255, 255));

        pnlCliente.setBackground(new java.awt.Color(249, 249, 252));
        pnlCliente.setPreferredSize(new java.awt.Dimension(900, 600));

        btnCliente.setBackground(new java.awt.Color(5, 4, 45));
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("+ Cliente");
        btnCliente.setToolTipText("Adicionar Cliente (ALT + C)");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        scrTblCliente.setBorder(null);

        tblClientes.setForeground(new java.awt.Color(5, 4, 45));
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome/Razão Social", "CPF/CNPJ", "Insc. Estadual", "Endereço", "Bairro", "Cidade", "UF", "Telefone", "E-mail", "Contato Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setMinimumSize(new java.awt.Dimension(10, 10));
        scrTblCliente.setViewportView(tblClientes);

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrTblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 440, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrTblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbbCadastro.addTab("Clientes", pnlCliente);

        pnlFornecedor.setBackground(new java.awt.Color(249, 249, 252));
        pnlFornecedor.setPreferredSize(new java.awt.Dimension(900, 600));

        btnFornecedor.setBackground(new java.awt.Color(5, 4, 45));
        btnFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        btnFornecedor.setText("+ Fornecedor");
        btnFornecedor.setToolTipText("Adicionar Fornecedor (ALT + F)");
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        scrTblFor.setBorder(null);

        tblFornecedor.setForeground(new java.awt.Color(5, 4, 45));
        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome/Razão Social", "CPF/CNPJ", "Insc. Estadual", "Endereço", "Bairro", "Cidade", "UF", "Telefone", "E-mail", "Contato Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFornecedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblFornecedor.setMinimumSize(new java.awt.Dimension(10, 10));
        scrTblFor.setViewportView(tblFornecedor);

        javax.swing.GroupLayout pnlFornecedorLayout = new javax.swing.GroupLayout(pnlFornecedor);
        pnlFornecedor.setLayout(pnlFornecedorLayout);
        pnlFornecedorLayout.setHorizontalGroup(
            pnlFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFornecedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrTblFor, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(pnlFornecedorLayout.createSequentialGroup()
                        .addComponent(txtBuscaForn, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 440, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFornecedorLayout.setVerticalGroup(
            pnlFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFornecedorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlFornecedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaForn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrTblFor, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbbCadastro.addTab("Fornecedores", pnlFornecedor);

        pnlButtons.setBackground(new java.awt.Color(255, 255, 255));
        pnlButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        btnExcluir.setBackground(new java.awt.Color(250, 250, 248));
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

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbbCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tbbCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
       
        Cliente telaCliente = new Cliente (this);
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
       
        Fornecedor telaFornecedor = new Fornecedor (this);
        telaFornecedor.setVisible(true);
    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
        boolean pgCliente = tbbCadastro.getSelectedIndex() == 0;
        int linha = pgCliente ? tblClientes.getSelectedRow() : tblFornecedor.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um " + (pgCliente ? "cliente" : "fornecedor")
                    + " para editar.");
            return;
        }

        if (pgCliente) {
            model.Cliente cliente = dao.ClienteDAO.listar().get(linha);
            Cliente telaEditar = new Cliente(this, cliente);
            telaEditar.setVisible(true);
            
        } else {
            model.Fornecedor fornecedor = dao.FornecedorDAO.listar().get(linha);
            Fornecedor telaEditar = new Fornecedor(this, fornecedor);
            telaEditar.setVisible(true);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
      
        boolean abaCliente = tbbCadastro.getSelectedIndex() == 0;
        int linha = abaCliente ? tblClientes.getSelectedRow() : tblFornecedor.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um " + (abaCliente ? "cliente" : "fornecedor") + " para excluir.");
            return;
        }

        if (abaCliente) {
            model.Cliente cliente = dao.ClienteDAO.listar().get(linha);
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Deseja excluir \"" + cliente.getNomeCliente() + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                dao.ClienteDAO.excluir(cliente);
                carregarTabelaClientes();
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
            }
        } else {
            model.Fornecedor fornecedor = dao.FornecedorDAO.listar().get(linha);
            int confirmacao = JOptionPane.showConfirmDialog(this,
                    "Deseja excluir \"" + fornecedor.getRazaoSocial() + "\"?",
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                dao.FornecedorDAO.excluir(fornecedor);
                carregarTabelaFornecedor();
                JOptionPane.showMessageDialog(this, "Fornecedor excluído com sucesso!");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    //formatacao
    
    private void formatacaoVisual () {
      
    //placeholder 
    txtBuscaCliente.putClientProperty("JTextField.placeholderText", "Buscar cliente...");
    txtBuscaForn.putClientProperty("JTextField.placeholderText", "Buscar fornecedor...");
        
    // tabelas
    Temas.formatarScroll(scrTblFor);
    Temas.formatarScroll(scrTblCliente);
      
    Temas.formatarTabela(tblClientes);
    Temas.formatarTabela(tblFornecedor);     
      
    }

    private void geraAcessbilidade() {

    btnCliente.setMnemonic(KeyEvent.VK_C);
    btnFornecedor.setMnemonic(KeyEvent.VK_F);
    btnEditar.setMnemonic(KeyEvent.VK_E);
    btnExcluir.setMnemonic(KeyEvent.VK_D);   
    
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFornecedor;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlFornecedor;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane scrTblCliente;
    private javax.swing.JScrollPane scrTblFor;
    private javax.swing.JTabbedPane tbbCadastro;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtBuscaForn;
    // End of variables declaration//GEN-END:variables
}
