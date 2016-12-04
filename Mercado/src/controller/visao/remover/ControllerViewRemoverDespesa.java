package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.gerenciais.DaoDespesa;
import modelo.estruturais.Operacao;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverDespesa;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverDespesa.
 * @author  Alison
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverDespesa extends ControllerViewRemover {
    private final ViewRemoverDespesa viewRemoverDespesa;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverDespesa(ViewRemoverDespesa oView) {
        super(oView);
        this.viewRemoverDespesa = oView;
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
        new DaoDespesa().remove(this.viewRemoverDespesa.getDespesa().getId());
        new DaoOperacao().insert(new Operacao("Despesa = " + this.viewRemoverDespesa.getDespesa().getId(), new DaoAcao().get(15L), this.viewRemoverDespesa.getUsuario()));
        new ViewMensagem(this.viewRemoverDespesa.getViewConsulta(), "Despesa Removida com Sucesso!").setVisible(true);
        this.viewRemoverDespesa.getViewConsulta().clear();
        this.viewRemoverDespesa.dispose();
    }
}