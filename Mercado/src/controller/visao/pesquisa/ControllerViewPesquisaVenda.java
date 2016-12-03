package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import visao.pesquisa.ViewPesquisaVenda;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Vendas.
 * @author  Hadyne
 */
public class ControllerViewPesquisaVenda extends ControllerViewModal {
    private final ViewPesquisaVenda viewPesquisaVenda;


    public ControllerViewPesquisaVenda(ViewPesquisaVenda oView) {
        super(oView);
        this.viewPesquisaVenda = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonSelect())) {
        }else if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonBack())) {
            this.viewPesquisaVenda.dispose();
        }
    }

    public void pesquisar() {
        String sCliente = this.viewPesquisaVenda.getTextFieldPesquisa().getText();

    }
    

}