package theme;


import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;


/**
 * Paleta de cores e estilos visuais utilizados no sistema
 * 
 * @author Elane
 */

public class Temas {

    //paleta de cores

    public static final Color COR_AZUL_ESCURO = new Color(0x05042D);
    public static final Color COR_AZUL_CLARO = new Color(0xCBE3FF);
    public static final Color COR_AZUL_FUNDO = new Color(0xF9F9FC);
    public static final Color COR_AZUL_ROYAL = new Color(0x0700D4);
    public static final Color COR_TEXTO_PADRAO = new Color(0x1E1E1E);
    public static final Color COR_PLACEHOLDER = new Color(0xAAAAAA);
    public static final Color COR_TABLEHEADER = new Color(0xFAFAF7);
    public static final Color COR_CARD_RESUMO = new Color(0xF0F2F7);
    public static final Color COR_TABLESELECTION = new Color (0x8596e3);
    public static final Color COR_MENU_HOVER = new Color(0x1E1B5E);


    //cards e tabela

    public static void formatarCard(JPanel panel) {

        panel.putClientProperty(FlatClientProperties.STYLE,"arc: 20; borderWidth: 1;");
        panel.setBackground(COR_CARD_RESUMO);
    }


    public static void formatarTabela(JTable tabela) {

           
        tabela.setBackground(Color.WHITE);
        tabela.getTableHeader().setBackground(COR_TABLEHEADER);
        tabela.setSelectionBackground(COR_TABLESELECTION);
        tabela.setForeground(COR_AZUL_ESCURO);
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabela.setFillsViewportHeight(true);
        tabela.setShowHorizontalLines(false);
        tabela.setShowVerticalLines(false);
     
    javax.swing.table.DefaultTableCellRenderer centralizado = new javax.swing.table.DefaultTableCellRenderer();
    centralizado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    for (int i = 0; i < tabela.getColumnCount(); i++) {
        tabela.getColumnModel().getColumn(i).setCellRenderer(centralizado);
    }
    
    }

    public static void formatarScroll (JScrollPane scroll) {
           
    scroll.putClientProperty(FlatClientProperties.STYLE,"borderColor: #eef3fc; borderWidth: 1");

    scroll.setViewportBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    scroll.getViewport().setBackground(Color.WHITE);
}
 
    //versão do sistema
    public static void addVersao(JPanel pnlInferior) {

        pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel lbVersao = new JLabel("v1.0.0");
        lbVersao.setForeground(Color.WHITE);
        
        pnlInferior.add(lbVersao);
    }
    
}
