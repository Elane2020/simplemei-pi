
package view;

import java.awt.*;
import javax.swing.*;
import model.Usuario;
import theme.Temas;

/**
 * Classe que hospeda e alterna os painéis (resumo, cadastro, relatórios, etc.).
 * 
 * @author Elane
*/

public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    private BorderLayout bordLayout;
    private Usuario usuarioLogado;
    
    
    //painéis da TelaPrincipal
    
    private ResumoPanel resumo;
    private CadastroPanel cadastro;
    private ReceitaPanel receita;
    private DespesaPanel despesa;
    private RelatorioPanel relatorio;
    private UtilitariosPanel utilitarios;
    private ConfiguracaoPanel configuracao;
    private UsuarioPanel usuarios;
    private BackupPanel backup;
    private SuportePanel suporte;
     
    
      public TelaPrincipal() {
        
         this((Usuario) null);
       
    }

    public TelaPrincipal(Usuario usuario) {
        initComponents();
        iconesMenu();
       
        
        this.usuarioLogado = usuario;
        
         
        this.getContentPane().setBackground(Temas.COR_AZUL_FUNDO);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        resumo = new ResumoPanel(usuarioLogado);
        cadastro = new CadastroPanel();
        receita = new ReceitaPanel();
        despesa = new DespesaPanel();
        relatorio = new RelatorioPanel();
        utilitarios = new UtilitariosPanel();
        configuracao = new ConfiguracaoPanel(usuarioLogado);
        usuarios = new UsuarioPanel(usuarioLogado);
        backup = new BackupPanel();
        suporte = new SuportePanel();
       
        abrirTela (resumo, btnResumo);
        
        resumo.exibePanel(receita, despesa);
        receita.exibePanel(resumo, despesa);
        despesa.exibePanel(resumo, receita);
            
        
    }
      
     
    private void iconesMenu () {
        
        ImageIcon iconeResumo = new ImageIcon(getClass().getResource("/img/ico_resumo.png"));
        ImageIcon iconeCadastro = new ImageIcon(getClass().getResource("/img/ico_cadastro.png"));
        ImageIcon iconeReceber = new ImageIcon(getClass().getResource("/img/ico_conta_receber.png"));
        ImageIcon iconePagar= new ImageIcon(getClass().getResource("/img/ico_conta_pagar.png"));
        ImageIcon iconeRelatorio = new ImageIcon(getClass().getResource("/img/ico_relatorio.png"));
        ImageIcon iconeUser = new ImageIcon(getClass().getResource("/img/ico_usuario.png"));
        ImageIcon iconeUtilitario = new ImageIcon(getClass().getResource("/img/ico_utilitario.png"));
        ImageIcon iconeConfig = new ImageIcon(getClass().getResource("/img/ico_config.png"));
        ImageIcon iconeBackup = new ImageIcon(getClass().getResource("/img/ico_backup.png"));
        ImageIcon iconeSuporte = new ImageIcon(getClass().getResource("/img/ico_suporte_menu.png"));
        
                
        btnResumo.setIcon(iconeResumo);
        btnCadastro.setIcon(iconeCadastro);
        btnContReceber.setIcon(iconeReceber);
        btnContPagar.setIcon(iconePagar);
        btnRelatorio.setIcon(iconeRelatorio);
        btnUtilitario.setIcon(iconeUtilitario);
        btnConfig.setIcon(iconeConfig);
        btnUsuario.setIcon(iconeUser);        
        btnSistema.setIcon(iconeBackup);
        btnSuporte.setIcon(iconeSuporte);
        
              
    }
    
    
    private void abrirTela(javax.swing.JPanel painel, javax.swing.JButton btnSelecionado) {

    pnlPrincipal.removeAll();
    pnlPrincipal.setLayout(new java.awt.BorderLayout());

    pnlPrincipal.add(painel, java.awt.BorderLayout.CENTER);

    pnlPrincipal.revalidate();
    pnlPrincipal.repaint();
    
        botaoSelecionado(btnSelecionado);
}
    
      
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavBar = new javax.swing.JPanel();
        lbSistema = new javax.swing.JLabel();
        lbIcoSistema = new javax.swing.JLabel();
        btnResumo = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnContReceber = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        btnSistema = new javax.swing.JButton();
        btnSuporte = new javax.swing.JButton();
        btnContPagar = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnUtilitario = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resumo");
        setBackground(new java.awt.Color(255, 255, 255));

        pnlNavBar.setBackground(new java.awt.Color(5, 4, 45));

        lbSistema.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lbSistema.setForeground(new java.awt.Color(255, 255, 255));
        lbSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSistema.setText("Gestão Financeira");
        lbSistema.setMaximumSize(new java.awt.Dimension(165, 15));
        lbSistema.setMinimumSize(new java.awt.Dimension(165, 15));
        lbSistema.setPreferredSize(new java.awt.Dimension(165, 15));

        lbIcoSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcoSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_mei.png"))); // NOI18N

        btnResumo.setBackground(new java.awt.Color(5, 4, 45));
        btnResumo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnResumo.setForeground(new java.awt.Color(255, 255, 255));
        btnResumo.setText("Resumo");
        btnResumo.setBorder(null);
        btnResumo.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnResumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumoActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(5, 4, 45));
        btnCadastro.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastro.setText("Cadastros");
        btnCadastro.setBorder(null);
        btnCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnContReceber.setBackground(new java.awt.Color(5, 4, 45));
        btnContReceber.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnContReceber.setForeground(new java.awt.Color(255, 255, 255));
        btnContReceber.setText("Contas a Receber");
        btnContReceber.setBorder(null);
        btnContReceber.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnContReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContReceberActionPerformed(evt);
            }
        });

        btnRelatorios.setBackground(new java.awt.Color(5, 4, 45));
        btnRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorios.setBorder(null);

        btnConfig.setBackground(new java.awt.Color(5, 4, 45));
        btnConfig.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnConfig.setText("Configurações");
        btnConfig.setBorder(null);
        btnConfig.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        btnSistema.setBackground(new java.awt.Color(5, 4, 45));
        btnSistema.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnSistema.setForeground(new java.awt.Color(255, 255, 255));
        btnSistema.setText("Sistema");
        btnSistema.setBorder(null);
        btnSistema.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSistemaActionPerformed(evt);
            }
        });

        btnSuporte.setBackground(new java.awt.Color(5, 4, 45));
        btnSuporte.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnSuporte.setForeground(new java.awt.Color(255, 255, 255));
        btnSuporte.setText("Suporte");
        btnSuporte.setBorder(null);
        btnSuporte.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuporteActionPerformed(evt);
            }
        });

        btnContPagar.setBackground(new java.awt.Color(5, 4, 45));
        btnContPagar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnContPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnContPagar.setText("Contas a Pagar");
        btnContPagar.setBorder(null);
        btnContPagar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnContPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContPagarActionPerformed(evt);
            }
        });

        btnRelatorio.setBackground(new java.awt.Color(5, 4, 45));
        btnRelatorio.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setText("Relatórios");
        btnRelatorio.setBorder(null);
        btnRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        btnUtilitario.setBackground(new java.awt.Color(5, 4, 45));
        btnUtilitario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnUtilitario.setForeground(new java.awt.Color(255, 255, 255));
        btnUtilitario.setText("Utilitários");
        btnUtilitario.setBorder(null);
        btnUtilitario.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUtilitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilitarioActionPerformed(evt);
            }
        });

        btnUsuario.setBackground(new java.awt.Color(5, 4, 45));
        btnUsuario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuários");
        btnUsuario.setBorder(null);
        btnUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavBarLayout = new javax.swing.GroupLayout(pnlNavBar);
        pnlNavBar.setLayout(pnlNavBarLayout);
        pnlNavBarLayout.setHorizontalGroup(
            pnlNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavBarLayout.createSequentialGroup()
                .addGroup(pnlNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNavBarLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lbIcoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNavBarLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlNavBarLayout.createSequentialGroup()
                .addComponent(btnRelatorios)
                .addGap(18, 18, 18)
                .addGroup(pnlNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfig, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUtilitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContPagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnContReceber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuporte, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlNavBarLayout.setVerticalGroup(
            pnlNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnResumo)
                .addGap(18, 18, 18)
                .addComponent(btnCadastro)
                .addGap(18, 18, 18)
                .addComponent(btnContReceber)
                .addGap(18, 18, 18)
                .addComponent(btnContPagar)
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUtilitario)
                .addGap(18, 18, 18)
                .addGroup(pnlNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfig)
                    .addComponent(btnRelatorios))
                .addGap(18, 18, 18)
                .addComponent(btnSistema)
                .addGap(18, 18, 18)
                .addComponent(btnUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnSuporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrincipal.setBackground(new java.awt.Color(249, 249, 252));
        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumoActionPerformed
        resumo.carregarTabela();
        abrirTela (resumo, btnResumo);
        
    }//GEN-LAST:event_btnResumoActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        
        abrirTela(cadastro, btnCadastro);
        
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnContReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContReceberActionPerformed
        receita.carregarTabela(); 
        abrirTela(receita, btnContReceber);
        
    }//GEN-LAST:event_btnContReceberActionPerformed

    private void btnContPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContPagarActionPerformed
        despesa.carregarTabela(); 
        abrirTela(despesa, btnContPagar);
        
    }//GEN-LAST:event_btnContPagarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        abrirTela (relatorio, btnRelatorio);
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        abrirTela(configuracao, btnConfig);
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSistemaActionPerformed
        abrirTela(backup, btnSistema);
    }//GEN-LAST:event_btnSistemaActionPerformed

    private void btnSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuporteActionPerformed
        abrirTela(suporte, btnSuporte);
    }//GEN-LAST:event_btnSuporteActionPerformed

    private void btnUtilitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilitarioActionPerformed
        abrirTela(utilitarios, btnUtilitario);
    }//GEN-LAST:event_btnUtilitarioActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        abrirTela(usuarios, btnUsuario);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void botaoSelecionado (javax.swing.JButton btnSelecionado) {

    javax.swing.JButton[] botoesMenu = {
        btnResumo, btnCadastro, btnContReceber, btnContPagar,
        btnRelatorio, btnUtilitario, btnConfig, btnSistema,
        btnUsuario, btnSuporte
    };

    for (javax.swing.JButton botao : botoesMenu) {
        botao.putClientProperty("JButton.buttonType", "tab");
        botao.setSelected(botao == btnSelecionado);
    }
}
    
    public static void main(String args[]) {
      
     //   java.awt.EventQueue.invokeLater(() -> new Resumo().setVisible(true));
        TelaPrincipal telaResumo = new TelaPrincipal();
        telaResumo.setVisible(true);
       
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnContPagar;
    private javax.swing.JButton btnContReceber;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnResumo;
    private javax.swing.JButton btnSistema;
    private javax.swing.JButton btnSuporte;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnUtilitario;
    private javax.swing.JLabel lbIcoSistema;
    private javax.swing.JLabel lbSistema;
    private javax.swing.JPanel pnlNavBar;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
