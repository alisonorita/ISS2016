package controller.visao.sistema;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;
import visao.estruturais.ViewLogin;
import visao.sistema.ViewSistemaLogoff;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewSistemaLogoff.
 * @author  Alison
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewSistemaLogoff extends ControllerViewModal {
    private final ViewSistemaLogoff viewSistemaLogoff;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewSistemaLogoff(ViewSistemaLogoff oView) {
        super(oView);
        this.viewSistemaLogoff = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewSistemaLogoff.getButtonYes())) {
            this.viewSistemaLogoff.dispose();
            this.viewSistemaLogoff.getView().dispose();
            new DaoOperacao().insert(new Operacao("Logoff pela View", new DaoAcao().get(2L), this.viewSistemaLogoff.getView().getUsuario()));
            new ViewLogin().setVisible(true);
        }else if (oEvento.getSource().equals(this.viewSistemaLogoff.getButtonNo())) {
            this.viewSistemaLogoff.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.viewSistemaLogoff.getFocusOwner().equals(this.viewSistemaLogoff.getButtonYes())) {
                this.viewSistemaLogoff.dispose();
                new DaoOperacao().insert(new Operacao("Logoff pela View", new DaoAcao().get(2L), this.viewSistemaLogoff.getView().getUsuario()));
                this.viewSistemaLogoff.getView().dispose();
                new ViewLogin().setVisible(true);
            }else if (this.viewSistemaLogoff.getFocusOwner().equals(this.viewSistemaLogoff.getButtonNo())) {
                this.viewSistemaLogoff.dispose();
            }
        }
    }
}