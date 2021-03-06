package controller.visao;

import controller.Controller;
import java.awt.event.KeyEvent;
import visao.View;

/**
 * <p>Classe responsavel por ser o <b>controlador</b> das classes View.</p>
 * @author  Felippe e Hadyne
 * @see     controller.Controller
 * @see     visao.ViewModal
 */
public abstract class ControllerView extends Controller {
    private final View view;
    
    public ControllerView(View oView) {
        super();
        this.view = oView;
    }

    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
        if (oKeyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.view.dispose();
        }
    }
}