package main;

import com.formdev.flatlaf.FlatLightLaf;
import dao.ConexaoJDBC;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import view.Login;


/**
 * Classe responsável por iniciar o sistema e aplicar o tema visual Flatlaf.
 *
 * @author Elane
 */

public class SimpleMEI_PI {

    public static void main(String[] args) {
        
         ConexaoJDBC c = new ConexaoJDBC();
            c.conectar();
            
            if (c.getConexao() != null) {
              JOptionPane.showMessageDialog(null, "Conexão bem sucedida!", "Sucesso", 
                      JOptionPane.INFORMATION_MESSAGE);
            }
    
      //  LancamentoDAO.carregarCSV("dados_teste.csv");
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Component.arc", 10);  
        UIManager.put("Button.arc", 12);
        
        FlatLightLaf.setup();
         
        java.awt.EventQueue.invokeLater(()-> {
          new Login().setVisible(true);
        //new TelaPrincipal().setVisible(true);
    
    });
    
    }
}
    
