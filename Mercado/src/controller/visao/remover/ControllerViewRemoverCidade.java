package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.dao.complementares.DaoCidade;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverCidade;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverCidade.
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverCidade extends ControllerViewRemover {
    private final ViewRemoverCidade viewRemoverCidade;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverCidade(ViewRemoverCidade oView) {
        super(oView);
        this.viewRemoverCidade = oView;
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
        try{
            new DaoCidade().remove(this.viewRemoverCidade.getCidade().getId());
            new DaoOperacao().insert(new Operacao("Cidade = " + this.viewRemoverCidade.getCidade().getId(), new DaoAcao().get(12L), this.viewRemoverCidade.getUsuario()));
            new ViewMensagem(this.viewRemoverCidade.getViewConsulta(), "Cidade Removida com Sucesso!").setVisible(true);
            this.viewRemoverCidade.getViewConsulta().clear();
            this.viewRemoverCidade.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a cidade, pois ela está atrelada à clientes."
            + "Por favor, exclua os clientes que possuem essa cidade em seu cadastro ou escolha outra cidade");
            this.viewRemoverCidade.getViewConsulta().clear();
            this.viewRemoverCidade.dispose(); 
        }       
    }
}