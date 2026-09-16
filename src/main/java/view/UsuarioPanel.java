
package view;

import java.awt.event.KeyEvent;
import model.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import theme.Temas;


/**
 * Painel de cadastro de usuários do sistema. 
 * Apenas o Gerente pode inserir/editar/excluir usuários.
 * 
 * @author Elane
 */

public class UsuarioPanel extends javax.swing.JPanel {
    
    private Usuario usuarioLogado;
    
    public UsuarioPanel() {
       this(null);
    }

    public UsuarioPanel(Usuario usuarioLogado) {
    initComponents();
    
    geraAcessbilidade();
    Temas.addVersao(pnlInferior);
    formatacaoVisual();
    
    
    this.usuarioLogado = usuarioLogado;
    carregarUsuarios();

  if (usuarioLogado.getTipo().equalsIgnoreCase("Gerente")) {

    btnSalvar.setEnabled(true);
    btnEditar.setEnabled(true);
    btnExcluir.setEnabled(true);

    } else {

    btnSalvar.setEnabled(false);
    btnEditar.setEnabled(false);
    btnExcluir.setEnabled(false);
    }
    }

    public void carregarUsuarios() {
    
    DefaultTableModel tableModel = (DefaultTableModel) tblUsuarios.getModel();
    tableModel.setRowCount(0);

    for (model.Usuario u : dao.UsuarioDAO.listar()) {
        tableModel.addRow(new Object[]{
            u.getId(), 
            u.getUsuario(), 
            u.getTipo(),
            u.getEmail() });
    }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        scrTabela = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        pnlInferior = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Usuários");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));
        pnlCard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Perfil", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setSelectionBackground(new java.awt.Color(133, 150, 227));
        scrTabela.setViewportView(tblUsuarios);

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(scrTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 294, Short.MAX_VALUE)
                .addGap(23, 23, 23))
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

        btnSalvar.setBackground(new java.awt.Color(5, 4, 45));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_salvar.png"))); // NOI18N
        btnSalvar.setText("Cadastrar");
        btnSalvar.setToolTipText("Cadastrar (ALT + S) ");
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlButtonsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnExcluir, btnSalvar});

        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlInferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButtons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            
   if (usuarioLogado == null || !usuarioLogado.getTipo().equalsIgnoreCase("Gerente")) {
        JOptionPane.showMessageDialog(this,"Apenas o Gerente pode editar usuários.","Acesso negado",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    int linha = tblUsuarios.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this,"Selecione um usuário para editar.","Aviso",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    Usuario usuario = dao.UsuarioDAO.listar().get(linha);

    UsuarioCad telaEditar = new UsuarioCad(this, usuario);  
    telaEditar.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        if (usuarioLogado == null || !usuarioLogado.getTipo().equalsIgnoreCase("Gerente")) {
        JOptionPane.showMessageDialog(this,"Apenas o Gerente pode excluir usuários.","Acesso negado",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    int linha = tblUsuarios.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this,"Selecione um usuário para excluir.","Aviso",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    Usuario usuario = dao.UsuarioDAO.listar().get(linha);

    int confirmacao = JOptionPane.showConfirmDialog(this,"Deseja realmente excluir \"" + usuario.getUsuario() + "\"?",
            "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

    if (confirmacao == JOptionPane.YES_OPTION) {
        dao.UsuarioDAO.excluir(usuario);
        carregarUsuarios();
        JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        UsuarioCad telaCadUsuario = new UsuarioCad (this);
        telaCadUsuario.setVisible(true);
    }//GEN-LAST:event_btnSalvarActionPerformed
   
   
    //formatacao
    
    private void formatacaoVisual () {
     
           
    // tabelas
    Temas.formatarScroll(scrTabela);
    Temas.formatarScroll(scrTabela);
      
    Temas.formatarTabela(tblUsuarios);
    Temas.formatarTabela(tblUsuarios);     
      
    }
    
    private void geraAcessbilidade() {

    btnSalvar.setMnemonic(KeyEvent.VK_S);
    btnEditar.setMnemonic(KeyEvent.VK_E);
    btnExcluir.setMnemonic(KeyEvent.VK_D);
    
    
   }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane scrTabela;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
