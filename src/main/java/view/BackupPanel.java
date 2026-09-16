
package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import dao.LancamentoDAO;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import model.Lancamento;
import theme.Temas;


public class BackupPanel extends javax.swing.JPanel {

    private File caminhoBackup;
    private boolean backupAuto = false;    
    private File arquivoBackup;

    
public BackupPanel() {
        initComponents();
        caminhoBackup = new File("backups");

    if (!caminhoBackup.exists()) {
        caminhoBackup.mkdir();
    }

    carregarListaBackups();
    
    geraAcessbilidade();
    Temas.addVersao(pnlInferior);
          
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        pnlFazerBackup = new javax.swing.JPanel();
        lbBackup = new javax.swing.JLabel();
        lbIco1 = new javax.swing.JLabel();
        chkBackup = new javax.swing.JCheckBox();
        lbTexto = new javax.swing.JLabel();
        btnDownload = new javax.swing.JButton();
        btnNuvem = new javax.swing.JButton();
        pnlButtonsUpload = new javax.swing.JPanel();
        lbRestaurar = new javax.swing.JLabel();
        lbIco2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lbSelecionar = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        srcPaneBkp = new javax.swing.JScrollPane();
        tAreaBkp = new javax.swing.JTextArea();
        lbLista = new javax.swing.JLabel();
        pnlInferior = new javax.swing.JPanel();

        setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Backup e Restauração");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        pnlFazerBackup.setBackground(new java.awt.Color(255, 255, 255));
        pnlFazerBackup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbBackup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbBackup.setForeground(new java.awt.Color(5, 4, 45));
        lbBackup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbBackup.setText("Fazer Backup");

        lbIco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_bancoDados.png"))); // NOI18N

        chkBackup.setText("Fazer backup automático dos dados");
        chkBackup.setToolTipText("Toda vez que fechar o programa, um arquivo de backup será gerado.");
        chkBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBackupActionPerformed(evt);
            }
        });

        lbTexto.setText("Crie cópias de segurança dos seus dados e restaure quando necessário.");

        btnDownload.setBackground(new java.awt.Color(5, 4, 45));
        btnDownload.setForeground(new java.awt.Color(255, 255, 255));
        btnDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_download.png"))); // NOI18N
        btnDownload.setText("Gerar Backup");
        btnDownload.setToolTipText("Gerar Backup (ALT + G)");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        btnNuvem.setBackground(new java.awt.Color(234, 239, 255));
        btnNuvem.setForeground(new java.awt.Color(5, 4, 45));
        btnNuvem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_upload.png"))); // NOI18N
        btnNuvem.setText("Copiar para Nuvem");
        btnNuvem.setToolTipText("Exportar para Nuvem");
        btnNuvem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuvemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFazerBackupLayout = new javax.swing.GroupLayout(pnlFazerBackup);
        pnlFazerBackup.setLayout(pnlFazerBackupLayout);
        pnlFazerBackupLayout.setHorizontalGroup(
            pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBackup)
                    .addComponent(lbIco1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTexto)
                    .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                        .addComponent(btnDownload)
                        .addGap(21, 21, 21)
                        .addComponent(btnNuvem))
                    .addComponent(chkBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFazerBackupLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDownload, btnNuvem});

        pnlFazerBackupLayout.setVerticalGroup(
            pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                        .addComponent(lbBackup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbIco1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFazerBackupLayout.createSequentialGroup()
                        .addGroup(pnlFazerBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                                .addComponent(lbTexto)
                                .addGap(30, 30, 30)
                                .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlFazerBackupLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnNuvem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkBackup)))
                .addContainerGap())
        );

        pnlButtonsUpload.setBackground(new java.awt.Color(255, 255, 255));
        pnlButtonsUpload.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlButtonsUpload.setForeground(new java.awt.Color(5, 4, 45));

        lbRestaurar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbRestaurar.setForeground(new java.awt.Color(5, 4, 45));
        lbRestaurar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbRestaurar.setText("Restaurar Backup");

        lbIco2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_restore.png"))); // NOI18N

        lbSelecionar.setText("Selecionar um arquivo de backup");

        btnPesquisar.setBackground(new java.awt.Color(53, 106, 227));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnPesquisar.setText("Procurar");
        btnPesquisar.setToolTipText("Buscar arquivo (ALT + P)");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnRestaurar.setBackground(new java.awt.Color(224, 224, 247));
        btnRestaurar.setForeground(new java.awt.Color(5, 4, 45));
        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_upload.png"))); // NOI18N
        btnRestaurar.setText("Restaurar Backup");
        btnRestaurar.setToolTipText("Restaurar (ALT + R)");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsUploadLayout = new javax.swing.GroupLayout(pnlButtonsUpload);
        pnlButtonsUpload.setLayout(pnlButtonsUploadLayout);
        pnlButtonsUploadLayout.setHorizontalGroup(
            pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsUploadLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlButtonsUploadLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbIco2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSelecionar)
                            .addGroup(pnlButtonsUploadLayout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(btnPesquisar)
                                .addGap(21, 21, 21)
                                .addComponent(btnRestaurar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlButtonsUploadLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPesquisar, btnRestaurar});

        pnlButtonsUploadLayout.setVerticalGroup(
            pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsUploadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsUploadLayout.createSequentialGroup()
                        .addComponent(lbRestaurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIco2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlButtonsUploadLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlButtonsUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsUploadLayout.createSequentialGroup()
                        .addComponent(btnRestaurar)
                        .addGap(31, 31, 31))))
        );

        pnlButtonsUploadLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPesquisar, btnRestaurar});

        tAreaBkp.setEditable(false);
        tAreaBkp.setColumns(20);
        tAreaBkp.setRows(5);
        tAreaBkp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tAreaBkp.setEnabled(false);
        srcPaneBkp.setViewportView(tAreaBkp);

        lbLista.setBackground(new java.awt.Color(53, 106, 227));
        lbLista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbLista.setForeground(new java.awt.Color(5, 4, 45));
        lbLista.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLista.setText("Lista de Backups disponíveis:");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFazerBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButtonsUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(srcPaneBkp)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbLista)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlFazerBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlButtonsUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcPaneBkp, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBackupActionPerformed
        
         backupAuto = chkBackup.isSelected();
         
    }//GEN-LAST:event_chkBackupActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        
        gerarBackup();
        carregarListaBackups();
    
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void gerarBackup() {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
    String nomeArquivo = "backup_" + sdf.format(new Date()) + ".csv";

    File arquivo = new File(caminhoBackup, nomeArquivo);

    try {

        FileWriter escritor = new FileWriter(arquivo, StandardCharsets.ISO_8859_1);

        escritor.write("Tipo;Data Operação;Data Vencimento;Setor;Contas;Descrição;"
                + "Valor Original;Cliente/Fornecedor;Status;Data Liquidação;Forma;"
                + "Valor Liquidado;Juros;Desconto\n");

        for (Lancamento l : LancamentoDAO.listar()) {

            escritor.write(
                    l.getTipo() + ";" +
                    l.getDataOperacao() + ";" +
                    l.getDataVencimento() + ";" +
                    l.getSetor() + ";" +
                    l.getContas() + ";" +
                    l.getDescricao() + ";" +
                    formatarValor(l.getValorOrig()) + ";" +
                    l.getClienteFornecedor() + ";" +
                    l.getStatus() + ";" +
                    l.getDataLiquidacao() + ";" +
                    l.getFormas() + ";" +
                    formatarValor(l.getValorLiquidado()) + ";" +
                    formatarValor(l.getJuros()) + ";" +
                    formatarValor(l.getDesconto()) + "\n"
            );
        }

        escritor.flush();
        escritor.close();

        JOptionPane.showMessageDialog(this, "Backup gerado com sucesso:\n" + arquivo.getName());

    } catch (IOException e) {

        JOptionPane.showMessageDialog(this,"Erro ao gerar backup: " + e.getMessage());
    }
}
    
    private void carregarListaBackups() {

    File[] arquivos = caminhoBackup.listFiles();

    if (arquivos == null) {
        tAreaBkp.setText("Nenhum backup encontrado.");
        return;
    }

    try {
        String nome = "";
        String dados = "";

        for (File arquivo : arquivos) {

            nome = arquivo.getName().toLowerCase();

            if (nome.endsWith(".csv")) {
                dados = dados + arquivo.getName() + "\n";
            }
        }

        if (dados.isEmpty()) {
            tAreaBkp.setText("Nenhum backup encontrado.");
        } else {
            tAreaBkp.setText(dados);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    
    private String formatarValor(double valor) {
        return String.valueOf(valor).replace(".", ",");
}
    
    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        
    File arquivoRestaurar = arquivoBackup;

    if (arquivoRestaurar == null) {

        String filtro = txtBuscar.getText().trim().toLowerCase();

        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Clique em \"Pesquisar\" e escolha um arquivo de backup antes de restaurar.");
            return;
        }

        File[] listaArquivos = caminhoBackup.listFiles();

        if (listaArquivos != null) {
            for (File arquivo : listaArquivos) {
                String nome = arquivo.getName().toLowerCase();
                if (nome.endsWith(".csv") && nome.contains(filtro)) {
                    arquivoRestaurar = arquivo;
                    break;
                }
            }
        }
    }

    if (arquivoRestaurar == null || !arquivoRestaurar.exists()) {
        JOptionPane.showMessageDialog(this, "Arquivo de Backup não encontrado");
        return;
    }

    int confirmacao = JOptionPane.showConfirmDialog(this,
            "Restaurar o backup \"" + arquivoRestaurar.getName() + "\"?\n" +
            "Todos os registros atuais serão apagados e substituídos pelos dados do backup.",
            "Confirmar Restauração", JOptionPane.YES_NO_OPTION);

    if (confirmacao != JOptionPane.YES_OPTION) {
        return;
    }

    LancamentoDAO.limparRegistro();
    int totalRestaurado = LancamentoDAO.restaurar(arquivoRestaurar);

    if (totalRestaurado < 0) {
        JOptionPane.showMessageDialog(this, "Erro ao restaurar o backup.");
    } else {
        JOptionPane.showMessageDialog(this,
                "Backup restaurado com sucesso!\n" + totalRestaurado + " lançamento(s) restaurado(s).");
    }

    arquivoBackup = null;
    txtBuscar.setText("");
    carregarListaBackups();    

    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnNuvemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuvemActionPerformed
        
     try {
        Desktop.getDesktop().browse(
            new URI("https://drive.google.com/drive")
        );
    } catch (IOException | URISyntaxException e) {
        JOptionPane.showMessageDialog(null, "Página não encontrada.","Erro",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    }//GEN-LAST:event_btnNuvemActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       
    JFileChooser fileChooser = new JFileChooser();

    fileChooser.setMultiSelectionEnabled(false);
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de backup (*.csv)","csv");
    fileChooser.setFileFilter(filtro);
    fileChooser.setCurrentDirectory(caminhoBackup);

    int resultado = fileChooser.showOpenDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {

        arquivoBackup = fileChooser.getSelectedFile();
        txtBuscar.setText(arquivoBackup.getName());

        JOptionPane.showMessageDialog(null,
                "Arquivo de backup selecionado: " + arquivoBackup.getName(),
                "Aviso", JOptionPane.INFORMATION_MESSAGE);

    } else {

        JOptionPane.showMessageDialog(null,"Nenhum arquivo foi selecionado.","Aviso",
            JOptionPane.INFORMATION_MESSAGE
        );
            }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    
    private void geraAcessbilidade() {

    btnDownload.setMnemonic(KeyEvent.VK_G);
    btnRestaurar.setMnemonic(KeyEvent.VK_R);
    btnPesquisar.setMnemonic(KeyEvent.VK_P);
    btnNuvem.setMnemonic(KeyEvent.VK_N);
    
    
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnNuvem;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JCheckBox chkBackup;
    private javax.swing.JLabel lbBackup;
    private javax.swing.JLabel lbIco1;
    private javax.swing.JLabel lbIco2;
    private javax.swing.JLabel lbLista;
    private javax.swing.JLabel lbRestaurar;
    private javax.swing.JLabel lbSelecionar;
    private javax.swing.JLabel lbTexto;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel pnlButtonsUpload;
    private javax.swing.JPanel pnlFazerBackup;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JScrollPane srcPaneBkp;
    private javax.swing.JTextArea tAreaBkp;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
