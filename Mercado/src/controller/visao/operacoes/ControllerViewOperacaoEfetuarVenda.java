package controller.visao.operacoes;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import modelo.cadastrais.Cliente;
import visao.extra.ViewAdicionarProdutoVenda;
import visao.operacoes.ViewOperacaoEfetuarVenda;


/**
 * Metodo responsavel por ser o <b>controlador</b> da View de Efetuar Venda.
 * @author Hadyne
 */
public class ControllerViewOperacaoEfetuarVenda extends ControllerViewModal {
    private final ViewOperacaoEfetuarVenda viewOperacaoEfetuarVenda;

   
    public ControllerViewOperacaoEfetuarVenda(ViewOperacaoEfetuarVenda oView) {
        super(oView);
        this.viewOperacaoEfetuarVenda = oView;

    }
    
    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonSearchCliente())) {
          
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonAdicionarItem())) {
            new ViewAdicionarProdutoVenda(this.viewOperacaoEfetuarVenda).setVisible(true);
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonRemoverItem())) {
            int iIndex = this.viewOperacaoEfetuarVenda.getTable().getSelectedRow();
           
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonSave())) {

            Cliente oCliente       = this.viewOperacaoEfetuarVenda.getCliente();
           
        }else if (oActionEvent.getSource().equals(this.viewOperacaoEfetuarVenda.getButtonBack())) {
            this.viewOperacaoEfetuarVenda.dispose();
        }
    }
    
   
}