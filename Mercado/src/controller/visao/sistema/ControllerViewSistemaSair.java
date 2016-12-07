package controller.visao.sistema;

import java.awt.event.ActionEvent;
import controller.visao.ControllerViewModal;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;
import visao.sistema.ViewSistemaSair;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewSistemaSair.
 * @author  Marcos
 * @see     controller.visao.ControllerViewModal
 */
public class ControllerViewSistemaSair extends ControllerViewModal {
    private final ViewSistemaSair viewSistemaSair;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewSistemaSair(ViewSistemaSair oView) {
        super(oView);
        this.viewSistemaSair = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewSistemaSair.getButtonYes())) {
            this.viewSistemaSair.dispose();
            this.viewSistemaSair.getView().dispose();
            new DaoOperacao().insert(new Operacao("Saida pelo Menu", new DaoAcao().get(3L), this.viewSistemaSair.getView().getUsuario()));
        }else if (oEvento.getSource().equals(this.viewSistemaSair.getButtonNo())) {
            this.viewSistemaSair.dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.viewSistemaSair.getFocusOwner().equals(this.viewSistemaSair.getButtonYes())) {
                new DaoOperacao().insert(new Operacao("Saida pelo Menu", new DaoAcao().get(3L), this.viewSistemaSair.getView().getUsuario()));
                this.viewSistemaSair.dispose();
                this.viewSistemaSair.getView().dispose();
            }else if (this.viewSistemaSair.getFocusOwner().equals(this.viewSistemaSair.getButtonNo())) {
                this.viewSistemaSair.dispose();
            }
        }
    }
}