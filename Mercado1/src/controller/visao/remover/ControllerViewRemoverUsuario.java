package controller.visao.remover;

import java.awt.event.ActionEvent;
import modelo.dao.estruturais.DaoUsuario;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverUsuario;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverUsuario.
 * @author  Alison
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverUsuario extends ControllerViewRemover {
    private final ViewRemoverUsuario viewRemoverUsuario;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverUsuario(ViewRemoverUsuario oView) {
        super(oView);
        this.viewRemoverUsuario = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void remover() {
        new DaoUsuario().remove(this.viewRemoverUsuario.getUsuario().getId());
        new DaoOperacao().insert(new Operacao("Usuario = " + this.viewRemoverUsuario.getUsuario().getId(), new DaoAcao().get(6L), this.viewRemoverUsuario.getUsuario()));
        new ViewMensagem(this.viewRemoverUsuario.getViewConsulta(), "Usuário Removido com Sucesso!").setVisible(true);
        this.viewRemoverUsuario.getViewConsulta().clear();
        this.viewRemoverUsuario.dispose();
    }
}