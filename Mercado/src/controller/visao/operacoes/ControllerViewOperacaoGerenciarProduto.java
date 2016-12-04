package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import visao.ajuda.ViewAjudaGerenciarProduto;
import visao.operacoes.ViewOperacaoGerenciarProduto;
import visao.pesquisa.ViewPesquisaProduto;

/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Gerenciamento de Produto.
 * @author Marcos
 */
public class ControllerViewOperacaoGerenciarProduto extends ControllerViewModal {
    private final ViewOperacaoGerenciarProduto viewOperacaoGerenciarProduto;
   
    public ControllerViewOperacaoGerenciarProduto(ViewOperacaoGerenciarProduto oView) {
        super(oView);
        this.viewOperacaoGerenciarProduto = oView;
    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarProduto.getButtonSearchProduto())) {
            new ViewPesquisaProduto(this.viewOperacaoGerenciarProduto).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarProduto.getButtonOk())) {
            this.viewOperacaoGerenciarProduto.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarProduto.getButtonVoltar())) {
            this.viewOperacaoGerenciarProduto.dispose();
        }else if (oActionEvent.getSource().equals(this.viewOperacaoGerenciarProduto.getButtonAjuda())) {
            new ViewAjudaGerenciarProduto(this.viewOperacaoGerenciarProduto).setVisible(true);
        }
    }
    
}