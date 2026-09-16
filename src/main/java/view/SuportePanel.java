
package view;

import theme.Temas;

/**
 * Painel com informações de contto do suporte.
 * 
 * @author Elane
 */
public class SuportePanel extends javax.swing.JPanel {

    public SuportePanel() {
        initComponents();
        Temas.addVersao(pnlInferior);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlCard = new javax.swing.JPanel();
        lbIcoSuporte = new javax.swing.JLabel();
        lbCanal = new javax.swing.JLabel();
        lbHelp = new javax.swing.JLabel();
        pnlTelefone = new javax.swing.JPanel();
        lbIcoWhatsApp = new javax.swing.JLabel();
        lbNumTel = new javax.swing.JLabel();
        pnlEmail = new javax.swing.JPanel();
        lbIcoEmail = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Suporte");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(603, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        lbIcoSuporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcoSuporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_suporte.png"))); // NOI18N

        lbCanal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbCanal.setForeground(new java.awt.Color(3, 8, 255));
        lbCanal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanal.setText("Canais de atendimento");

        lbHelp.setForeground(new java.awt.Color(5, 4, 45));
        lbHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHelp.setText("Precisando de Ajuda?");

        pnlTelefone.setBackground(new java.awt.Color(255, 255, 255));
        pnlTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 102)));
        pnlTelefone.setForeground(new java.awt.Color(249, 249, 252));

        lbIcoWhatsApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcoWhatsApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_zap.png"))); // NOI18N

        lbNumTel.setText("WhatsApp: (91) 99999-9999");

        javax.swing.GroupLayout pnlTelefoneLayout = new javax.swing.GroupLayout(pnlTelefone);
        pnlTelefone.setLayout(pnlTelefoneLayout);
        pnlTelefoneLayout.setHorizontalGroup(
            pnlTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcoWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNumTel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTelefoneLayout.setVerticalGroup(
            pnlTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTelefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbNumTel)
                    .addComponent(lbIcoWhatsApp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 8, 255)));
        pnlEmail.setForeground(new java.awt.Color(249, 249, 252));

        lbIcoEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcoEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_email.png"))); // NOI18N

        lbEmail.setText("elanedosanjos27@gmail.com");

        javax.swing.GroupLayout pnlEmailLayout = new javax.swing.GroupLayout(pnlEmail);
        pnlEmail.setLayout(pnlEmailLayout);
        pnlEmailLayout.setHorizontalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEmailLayout.setVerticalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbEmail)
                    .addComponent(lbIcoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbIcoSuporte)
                            .addComponent(lbHelp))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCardLayout.createSequentialGroup()
                        .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbCanal))
                        .addGap(46, 46, 46))))
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCardLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbCanal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHelp)
                .addGap(18, 18, 18)
                .addComponent(lbIcoSuporte, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlInferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCanal;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHelp;
    private javax.swing.JLabel lbIcoEmail;
    private javax.swing.JLabel lbIcoSuporte;
    private javax.swing.JLabel lbIcoWhatsApp;
    private javax.swing.JLabel lbNumTel;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JPanel pnlEmail;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JPanel pnlTelefone;
    // End of variables declaration//GEN-END:variables
}
