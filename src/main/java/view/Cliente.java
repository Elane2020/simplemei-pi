package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Endereco;

public class Cliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cliente.class.getName());
    private CadastroPanel cadastroPanel;
    private model.Cliente editarRegistro;

    
    public Cliente(CadastroPanel cadastroPanel, model.Cliente editarRegistro) {
        initComponents();
        formatacaoVisual();
        formatoFone(txtTelefone);
        formatoCEP(txtCEP);
        
        this.cadastroPanel = cadastroPanel;
        this.editarRegistro = editarRegistro;

        if (editarRegistro != null) {
            lbTitulo.setText("Editar Cliente");
            preencherCampos();
            
        }
        
        geraAcessbilidade();
    }

    public Cliente(CadastroPanel cadastroPanel) {
        this(cadastroPanel, null);
        
    }

    private void preencherCampos() {
        
        cboxTipoCliente.setSelectedItem(editarRegistro.getTipoCliente());
        txtNomeCliente.setText(editarRegistro.getNomeCliente());
        txtDOC.setText(editarRegistro.getNumCNPJ());
        txtIE.setText(editarRegistro.getNumIE());
        txtEndereco.setText(editarRegistro.getEndereco().getLogradouro());
        txtBairro.setText(editarRegistro.getEndereco().getBairro());
        txtCidade.setText(editarRegistro.getEndereco().getCidade());
        cboxUF.setSelectedItem(editarRegistro.getEndereco().getEstado());
        txtCEP.setText(editarRegistro.getEndereco().getCep());
        txtTelefone.setText(editarRegistro.getTelefone());
        txtResponsavel.setText(editarRegistro.getResponsavel());
        txtEmail.setText(editarRegistro.getEmail());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadCliente = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        lbTipoCliente = new javax.swing.JLabel();
        cboxTipoCliente = new javax.swing.JComboBox<>();
        lbNomeCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lbDocumento = new javax.swing.JLabel();
        lbDocumento1 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        lbEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lbBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lbCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lbUF = new javax.swing.JLabel();
        cboxUF = new javax.swing.JComboBox<>();
        lbCEP = new javax.swing.JLabel();
        lbTelefone = new javax.swing.JLabel();
        lbResponsavel = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlInferior = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDOC = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlCadCliente.setBackground(new java.awt.Color(234, 239, 255));

        pnlSuperior.setBackground(new java.awt.Color(255, 255, 255));
        pnlSuperior.setMaximumSize(new java.awt.Dimension(900, 600));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitulo.setText("Cadastro de Cliente");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo))
        );

        lbTipoCliente.setText("Tipo de Cliente:");

        cboxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "CPF", "CNPJ" }));

        lbNomeCliente.setText("Nome/Razão Social:");

        txtNomeCliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lbDocumento.setText("CPF/CNPJ:");

        lbDocumento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDocumento1.setText("I.E:");

        txtIE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbEndereco.setText("Endereço:");

        txtEndereco.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lbBairro.setText("Bairro:");

        txtBairro.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lbCidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCidade.setText("Cidade:");

        txtCidade.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lbUF.setText("UF:");

        cboxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lbCEP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCEP.setText("CEP:");

        lbTelefone.setText("Telefone:");

        lbResponsavel.setText("Responsável:");

        txtResponsavel.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lbEmail.setText("E-mail:");

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        pnlInferior.setBackground(new java.awt.Color(255, 255, 255));
        pnlInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlInferior.setForeground(new java.awt.Color(204, 204, 204));
        pnlInferior.setPreferredSize(new java.awt.Dimension(213, 25));

        btnSalvar.setBackground(new java.awt.Color(5, 4, 45));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar (ALT + S)");
        btnSalvar.setIconTextGap(10);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(249, 249, 252));
        btnCancelar.setForeground(new java.awt.Color(5, 4, 45));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico_cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar (ALT + X)");
        btnCancelar.setIconTextGap(10);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInferiorLayout = new javax.swing.GroupLayout(pnlInferior);
        pnlInferior.setLayout(pnlInferiorLayout);
        pnlInferiorLayout.setHorizontalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInferiorLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnSalvar)
                .addGap(21, 21, 21)
                .addComponent(btnCancelar)
                .addGap(145, 145, 145))
        );

        pnlInferiorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnSalvar});

        pnlInferiorLayout.setVerticalGroup(
            pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInferiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        txtDOC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDOCKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlCadClienteLayout = new javax.swing.GroupLayout(pnlCadCliente);
        pnlCadCliente.setLayout(pnlCadClienteLayout);
        pnlCadClienteLayout.setHorizontalGroup(
            pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCadClienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(lbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbUF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbTelefone)
                        .addComponent(lbEmail)
                        .addComponent(lbTipoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadClienteLayout.createSequentialGroup()
                        .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadClienteLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lbResponsavel)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCEP)
                                    .addComponent(lbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)))
                        .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(txtCidade)
                            .addComponent(txtCEP)))
                    .addComponent(txtEndereco)
                    .addComponent(txtEmail)
                    .addGroup(pnlCadClienteLayout.createSequentialGroup()
                        .addComponent(txtDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lbDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomeCliente))
                .addGap(23, 23, 23))
            .addComponent(pnlInferior, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        pnlCadClienteLayout.setVerticalGroup(
            pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadClienteLayout.createSequentialGroup()
                .addComponent(pnlSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipoCliente)
                    .addComponent(cboxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeCliente)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDocumento)
                    .addComponent(lbDocumento1)
                    .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDOC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUF)
                    .addComponent(cboxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTelefone)
                    .addComponent(lbResponsavel)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlCadClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(pnlInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String tipoCliente = (String) cboxTipoCliente.getSelectedItem();
        String nomeCliente = txtNomeCliente.getText();
        String cpfCnpj = txtDOC.getText();
        String ie = txtIE.getText();
        Endereco endereco = new Endereco();
        String uf = (String) cboxUF.getSelectedItem();
        String telefone = txtTelefone.getText();
        String responsavel = txtResponsavel.getText();
        String email = txtEmail.getText();      
        
        if (tipoCliente == null || tipoCliente.equals("Selecione")) {       
        JOptionPane.showMessageDialog(null, "O Campo 'Tipo' deve ser preenchido!");
        cboxTipoCliente.requestFocusInWindow();    
        return;
        }
        
        if (tipoCliente.equalsIgnoreCase("CPF") 
                && (!cpfCnpj.matches("[0-9]{3}[\\.][0-9]{3}[\\.][0-9]{3}[-][0-9]{2}") 
                && !cpfCnpj.matches("[0-9]{11}"))) {
        JOptionPane.showMessageDialog(null, "O campo deve conter um CPF válido!");
        txtDOC.requestFocusInWindow();
        return;
        }
                
        if (tipoCliente.equalsIgnoreCase("CNPJ")
                && !cpfCnpj.matches("[0-9]{2}[\\.][0-9]{3}[\\.][0-9]{3}[/][0-9]{4}[-][0-9]{2}") 
                && !cpfCnpj.matches("[0-9]{14}")) {
        JOptionPane.showMessageDialog(null, "O campo deve conter um CNPJ válido!");
        txtDOC.requestFocusInWindow();
        return;
        }
        
        if (nomeCliente.trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "O campo 'Nome/Razão Social' deve ser preenchido!");
        txtNomeCliente.requestFocusInWindow();
        return;
        }
        
        if (ie.isEmpty()) {       
        JOptionPane.showMessageDialog(null, "O Campo 'Inscrição Estadual' deve ser preenchido!");
        txtIE.requestFocusInWindow();
         return;
        }
        
        if (txtEndereco.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "O campo 'Logradouro' deve ser preenchido!");
        txtEndereco.requestFocusInWindow();
        return;
        }
        
        if (txtBairro.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "O campo 'Bairro' deve ser preenchido!");
        txtBairro.requestFocusInWindow();
        return;
        }
        
        if (txtCidade.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "O campo 'Cidade' deve ser preenchido!");
        txtCidade.requestFocusInWindow();
        return;
        }
            
        
        if (uf == null || uf.equals("Selecione")){              
        JOptionPane.showMessageDialog(null, "O campo 'UF' deve ser preenchido!");
        cboxUF.requestFocusInWindow();
        return;
        }
        
        if (txtCEP.getText().trim().isEmpty()){              
        JOptionPane.showMessageDialog(null, "O campo 'CEP' deve ser preenchido!");
        txtCEP.requestFocusInWindow();
        return;
        
        }
        
        if (!telefone.matches("\\(?[1-9]{2}\\)?\\s?9[0-9]{4}[-.]?[0-9]{4}")) {
        JOptionPane.showMessageDialog(null, "O campo 'Telefone' deve conter um número válido!");
        txtTelefone.requestFocusInWindow();
        return;
        }
        
        if (responsavel.isEmpty()) {              
        JOptionPane.showMessageDialog(null, "O campo 'Responsável' deve ser preenchido!");
        txtResponsavel.requestFocusInWindow();
        return;
        }
        
        if (email.isEmpty()) {              
        JOptionPane.showMessageDialog(null, "O campo 'E-mail' deve ser preenchido!");
        txtEmail.requestFocusInWindow();
        return;
        

        } else {  
                   
        endereco.setLogradouro(txtEndereco.getText());
        endereco.setBairro(txtBairro.getText());
        endereco.setCep(txtCEP.getText());
        endereco.setCidade(txtCidade.getText());
        endereco.setEstado(uf);
        

        if (editarRegistro != null) {
            editarRegistro.setNomeCliente(nomeCliente);
            editarRegistro.setTipoCliente(tipoCliente);
            editarRegistro.setNumCNPJ(cpfCnpj);
            editarRegistro.setNumIE(ie);
            editarRegistro.setEndereco(endereco);
            editarRegistro.setEmail(email);
            editarRegistro.setTelefone(telefone);
            editarRegistro.setResponsavel(responsavel);
            
            dao.ClienteDAO.atualizar(editarRegistro);
            
        } else {
            model.Cliente cliente = new model.Cliente(
                nomeCliente, tipoCliente, cpfCnpj, ie,
                endereco, email, telefone, responsavel
            );
            
            dao.ClienteDAO.adicionar(cliente);
            
        }

        if (cadastroPanel != null) cadastroPanel.carregarTabelaClientes();

        JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
        
        limparCampos();
        
        }
    }
   
    private void limparCampos(){
        cboxTipoCliente.setSelectedIndex(0);
        txtNomeCliente.setText("");
        txtDOC.setText("");
        txtIE.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cboxUF.setSelectedIndex(0);
        txtCEP.setText("");
        txtTelefone.setText("");
        txtResponsavel.setText("");
        txtEmail.setText("");
        
   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose ();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDOCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDOCKeyReleased
        formatoDocumento();
    }//GEN-LAST:event_txtDOCKeyReleased

    //formatacao
    
    private void formatacaoVisual(){
        
    //placeholder
    txtNomeCliente.putClientProperty("JTextField.placeholderText", "Nome ou Razão Social...");
    txtEndereco.putClientProperty("JTextField.placeholderText", "Logradouro, nº casa/apartamento...");
        
    }
    
    //inputs
    private void formatoDocumento() {
    
    String documento = txtDOC.getText().replaceAll("\\D", "");
    String formatoDoc;

    if ("CPF".equals(cboxTipoCliente.getSelectedItem())) {
        if (documento.length() > 11) documento = documento.substring(0, 11);
        
        if (documento.length() <= 3) {
            formatoDoc = documento;
        } else if (documento.length() <= 6) {
            formatoDoc = documento.substring(0, 3) + "." + documento.substring(3);
        } else if (documento.length() <= 9) {
            formatoDoc = documento.substring(0, 3) + "." + documento.substring(3, 6) + "." + documento.substring(6);
        } else {
            formatoDoc = documento.substring(0, 3) + "." + documento.substring(3, 6) + "." +
                         documento.substring(6, 9) + "-" + documento.substring(9);
        }
    } else if ("CNPJ".equals(cboxTipoCliente.getSelectedItem())) {
        if (documento.length() > 14) documento = documento.substring(0, 14);
        
        if (documento.length() <= 2) {
            formatoDoc = documento;
        } else if (documento.length() <= 5) {
            formatoDoc = documento.substring(0, 2) + "." + documento.substring(2);
        } else if (documento.length() <= 8) {
            formatoDoc = documento.substring(0, 2) + "." + documento.substring(2, 5) + "." + documento.substring(5);
        } else if (documento.length() <= 12) {
            formatoDoc = documento.substring(0, 2) + "." + documento.substring(2, 5) + "." +
                         documento.substring(5, 8) + "/" + documento.substring(8);
        } else {
            formatoDoc = documento.substring(0, 2) + "." + documento.substring(2, 5) + "." +
                         documento.substring(5, 8) + "/" + documento.substring(8, 12) + "-" + documento.substring(12);
        }
    } else {
        formatoDoc = documento; 
    }

   
    if (!txtDOC.getText().equals(formatoDoc)) {
        txtDOC.setText(formatoDoc);
        txtDOC.setCaretPosition(formatoDoc.length());
    }
    }
    
    private void formatoFone(javax.swing.JFormattedTextField campo) {
          
        try {
            javax.swing.text.MaskFormatter formatoFone = new javax.swing.text.MaskFormatter("(##) #####-####");
            formatoFone.setPlaceholderCharacter(' ');
            formatoFone.install(campo);
            
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
    
    private void formatoCEP(javax.swing.JFormattedTextField campo) {

    try {
        javax.swing.text.MaskFormatter formatoCEP =
                new javax.swing.text.MaskFormatter("#####-###");

        formatoCEP.setPlaceholderCharacter(' ');
        formatoCEP.install(campo);

    } catch (java.text.ParseException e) {
        e.printStackTrace();
    }
}
  
    private void geraAcessbilidade() {

    btnSalvar.setMnemonic(KeyEvent.VK_S);
    btnCancelar.setMnemonic(KeyEvent.VK_X);
       
    
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboxTipoCliente;
    private javax.swing.JComboBox<String> cboxUF;
    private javax.swing.JLabel lbBairro;
    private javax.swing.JLabel lbCEP;
    private javax.swing.JLabel lbCidade;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbDocumento1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndereco;
    private javax.swing.JLabel lbNomeCliente;
    private javax.swing.JLabel lbResponsavel;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JLabel lbTipoCliente;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbUF;
    private javax.swing.JPanel pnlCadCliente;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtDOC;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
