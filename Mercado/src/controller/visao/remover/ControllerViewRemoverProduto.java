package controller.visao.remover;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.dao.cadastrais.DaoProduto;
import visao.mensagens.ViewMensagem;
import visao.remover.ViewRemoverProduto;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.estruturais.Operacao;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewRemoverProduto.
 * @author  Marcos
 * @see     controller.visao.remover.ControllerViewRemover
 */
public class ControllerViewRemoverProduto extends ControllerViewRemover {
    private final ViewRemoverProduto viewRemoverProduto;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewRemoverProduto(ViewRemoverProduto oView) {
        super(oView);
        this.viewRemoverProduto = oView;
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
        new DaoProduto().remove(this.viewRemoverProduto.getProduto().getId());
        new DaoOperacao().insert(new Operacao("Produto = " + this.viewRemoverProduto.getProduto().getId(), new DaoAcao().get(27L), this.viewRemoverProduto.getUsuario()));
        new ViewMensagem(this.viewRemoverProduto.getViewConsulta(), "Produto Removido com Sucesso!").setVisible(true);
        this.viewRemoverProduto.getViewConsulta().clear();
        this.viewRemoverProduto.dispose();
    }
}