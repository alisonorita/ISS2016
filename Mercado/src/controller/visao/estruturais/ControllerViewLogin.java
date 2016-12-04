package controller.visao.estruturais;


import funct.FunctString;
import java.awt.event.ActionEvent;
import controller.visao.ControllerView;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.estruturais.DaoUsuario;
import modelo.estruturais.Operacao;
import modelo.estruturais.Usuario;
import visao.estruturais.ViewLogin;
import visao.estruturais.ViewMenu;
import visao.mensagens.ViewErro;


/**
 * Classe responsavel por ser o <b>controlador</b> da ViewLogin.
 * @author  Hadyne
 * @see     controller.Controller
 */
public class ControllerViewLogin extends ControllerView {
    private final ViewLogin   viewLogin;
    private final DaoUsuario  daoUsuario;
    private final FunctString functString;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewLogin(ViewLogin oView) {
        super(oView);
        this.viewLogin   = oView;
        this.daoUsuario  = new DaoUsuario();
        this.functString = new FunctString();
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewLogin.getButtonOk())) {
            this.login();
        }else if (oEvento.getSource().equals(this.viewLogin.getButtonClear())) {
            this.viewLogin.clear();
        }else if (oEvento.getSource().equals(this.viewLogin.getButtonExit())) {
            this.viewLogin.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if ((oKeyEvent.getKeyCode() == KeyEvent.VK_F1) || 
            (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER)) {
            this.login();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F2) {
            this.viewLogin.clear();
        }else if (oKeyEvent.getKeyCode() == KeyEvent.VK_F3) {
            this.viewLogin.dispose();
        }   
    }
    
    private void login() {
        String  sLogin   = this.viewLogin.getTextFieldLogin().getText();
        String  sSenha   = this.viewLogin.getTextFieldSenha().getText();
        Usuario oUsuario = this.daoUsuario.findUsuarioByLogin(sLogin);
        
    }
}