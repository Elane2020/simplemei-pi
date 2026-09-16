
package view;

import com.formdev.flatlaf.FlatClientProperties;
import dao.UsuarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * Tela de autenticação do sistema.
 * 
 * @author Elane
 */
public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
  
    public Login() {
        initComponents();
        formatacaoVisual();

        
    }
    
    private void formatacaoVisual () {
        
    //icones dentro dos inputs
    ImageIcon iconeUser = new ImageIcon(getClass().getResource("/img/ico_user.png"));
    ImageIcon iconeCadeado = new ImageIcon(getClass().getResource("/img/ico_cadeado.png"));
        
    txtUsuario.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, iconeUser);
    tSenha.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, iconeCadeado);
        
       
    //placeholder 
    txtUsuario.putClientProperty("JTextField.placeholderText", "Digite seu usuário...");
    tSenha.putClientProperty("JTextField.placeholderText", "Digite sua senha...");
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAzul = new javax.swing.JPanel();
        lbILogo = new javax.swing.JLabel();
        lbBV = new javax.swing.JLabel();
        lbAcesso = new javax.swing.JLabel();
        pnlBranco = new javax.swing.JPanel();
        lbIcoUser = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        tSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnAcesso = new javax.swing.JButton();
        btnEsquece = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        pnlAzul.setBackground(new java.awt.Color(5, 4, 45));

        lbILogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_simpleMEI.png"))); // NOI18N

        lbBV.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lbBV.setForeground(new java.awt.Color(255, 255, 255));
        lbBV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBV.setText("Seja bem-vindo(a)!");

        lbAcesso.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbAcesso.setForeground(new java.awt.Color(255, 255, 255));
        lbAcesso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAcesso.setText("acesse o sistema");

        javax.swing.GroupLayout pnlAzulLayout = new javax.swing.GroupLayout(pnlAzul);
        pnlAzul.setLayout(pnlAzulLayout);
        pnlAzulLayout.setHorizontalGroup(
            pnlAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzulLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbILogo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        pnlAzulLayout.setVerticalGroup(
            pnlAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAzulLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbILogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lbBV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBranco.setBackground(new java.awt.Color(255, 255, 255));

        lbIcoUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconeUser.png"))); // NOI18N

        btnEntrar.setBackground(new java.awt.Color(98, 132, 224));
        btnEntrar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("➜ Entrar");
        btnEntrar.setActionCommand("");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnAcesso.setForeground(new java.awt.Color(5, 4, 45));
        btnAcesso.setText("Primeiro Acesso");
        btnAcesso.setBorder(null);
        btnAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessoActionPerformed(evt);
            }
        });

        btnEsquece.setForeground(new java.awt.Color(5, 4, 45));
        btnEsquece.setText("Esqueci minha senha");
        btnEsquece.setBorder(null);
        btnEsquece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsqueceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBrancoLayout = new javax.swing.GroupLayout(pnlBranco);
        pnlBranco.setLayout(pnlBrancoLayout);
        pnlBrancoLayout.setHorizontalGroup(
            pnlBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrancoLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrancoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbIcoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(pnlBrancoLayout.createSequentialGroup()
                        .addGroup(pnlBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(tSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(42, Short.MAX_VALUE))))
            .addGroup(pnlBrancoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEsquece)
                .addGap(22, 22, 22))
        );
        pnlBrancoLayout.setVerticalGroup(
            pnlBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrancoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbIcoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(pnlBrancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnEsquece)
                    .addComponent(btnAcesso))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBranco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAzul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBranco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessoActionPerformed
                       
         JOptionPane.showMessageDialog(null, "Uma solicitação de cadastro foi enviada para o ADMINISTRADOR.", "Enviada",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAcessoActionPerformed

    private void btnEsqueceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsqueceActionPerformed
       
         JOptionPane.showMessageDialog(null, "A senha foi enviada para o seu e-mail cadastrado.", "Enviada",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEsqueceActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
                               
    String usuarioDigitado = txtUsuario.getText().trim();
    String senhaDigitada = new String(tSenha.getPassword());

    if (usuarioDigitado.isEmpty() || senhaDigitada.isEmpty()) {

        JOptionPane.showMessageDialog(null, "Preencha usuário e senha.", "Aviso",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    Usuario usuario = usuarioDAO.autenticar(usuarioDigitado,senhaDigitada);

    if (usuario != null) {

        JOptionPane.showMessageDialog(null,"Bem-vindo(a), " + usuario.getUsuario() + "!", "Login efetuado",
                JOptionPane.INFORMATION_MESSAGE
        );

         new TelaPrincipal(usuario).setVisible(true);
         this.dispose();

    } else {

    JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos.","Erro",
            JOptionPane.ERROR_MESSAGE
    );

    tSenha.setText("");
    txtUsuario.requestFocus();
                }
    }//GEN-LAST:event_btnEntrarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcesso;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnEsquece;
    private javax.swing.JLabel lbAcesso;
    private javax.swing.JLabel lbBV;
    private javax.swing.JLabel lbILogo;
    private javax.swing.JLabel lbIcoUser;
    private javax.swing.JPanel pnlAzul;
    private javax.swing.JPanel pnlBranco;
    private javax.swing.JPasswordField tSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
