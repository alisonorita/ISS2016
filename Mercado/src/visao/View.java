/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controller.Controller;
import funct.FunctString;
import funct.FunctFrame;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Felippe e Hadyne
 */
public abstract class View extends JFrame{
    
    protected Controller controller;

    public View() {
       super();
       this.setSettings();
        
    }
    
    /**
     * Metodo responsavel por definir propriedades padrao para a View.
     */
    private void setSettings() {
        this.setSize(800, 550);
        this.setLocation(200, 100);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/icone.jpg")).getImage());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    /**
     * Metodo responsavel por adicionar linhas em uma Frame.
     * @param iLinhas Número de Linhas a serem adicionadas.
     */
    protected void addLinhas(int iLinhas) {
        for (int i = 0; i < iLinhas; ++i) {
            this.add(new JLabel(new FunctString().getEspacos(300)));
        }
    }
    
     /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JTextField</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @param  iSize Tamanho do JTextField.
     * @return JTextField.
     */
    protected JTextField createTextField(int iSize) {
        JTextField jTextField = new JTextField(iSize);
                   jTextField.addKeyListener(this.controller);
        return     jTextField;
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JPasswordTextField</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @param  iSize Tamanho do JPasswordField.
     * @return JPasswordField.
     */
    protected JPasswordField createPasswordField(int iSize) {
        JPasswordField jPasswordField = new JPasswordField(iSize);
                       jPasswordField.addKeyListener(this.controller);
        return         jPasswordField;
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JButton</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @param  sMessage  Mensagem a ser exibida no Botão.
     * @param  sUrlImage Imagem a ser exibida no Botão.
     * @return JButton
     */
    protected JButton createButton(String sMessage, String sUrlImage) {
        JButton jButton = new JButton(new FunctFrame().createImage("buttons/" + sUrlImage));
                jButton.setText(sMessage);
                jButton.addActionListener(this.controller);
        return  jButton;
    }
    
    /**
     * <p>Metodo responsavel por instanciar e retornar um <b>JMenuItem</b>.</p>
     * <p>Adiciona um listener da biblioteca como padrao.</p>
     * @param  sTitle     Título a ser exibido no Item do Menu.
     * @param  sUrlImage  Imagem a ser exibida no Item do Menu.
     * @return JMenuItem
     */
    protected JMenuItem createMenuItem(String sTitle, String sUrlImage) {
        JMenuItem jMenuItem = new JMenuItem(sTitle, new FunctFrame().createImage("icones/" + sUrlImage));
                  jMenuItem.addActionListener(this.controller);
        return    jMenuItem;
    }
    
    
    
}
