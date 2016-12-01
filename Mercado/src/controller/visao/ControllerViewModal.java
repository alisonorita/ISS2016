package controller.visao;

import controller.Controller;
import java.awt.event.KeyEvent;
import visao.ViewModal;

/**
 * <p>Classe responsavel por ser o <b>controlador</b> das classes ViewModal.</p>
 * @author  Alison e Marcos
 * @see     controller.Controller
 * @see     visao.ViewModal
 */
public abstract class ControllerViewModal extends Controller {
    private final ViewModal viewModal;
    
    public ControllerViewModal(ViewModal oView) {
        super();
        this.viewModal = oView;
    }

    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.viewModal.dispose();
        }
    }
}