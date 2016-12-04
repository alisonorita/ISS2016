package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.relacionais.saida.DaoVenda;
import modelo.relacionais.saida.Venda;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaVenda;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Vendas.
 * @author  Hadyne
 */
public class ControllerViewPesquisaVenda extends ControllerViewModal {
    private final ViewPesquisaVenda viewPesquisaVenda;
    private final DaoVenda          daoVenda;
    private       List<Venda>       vendas;

    public ControllerViewPesquisaVenda(ViewPesquisaVenda oView) {
        super(oView);
        this.viewPesquisaVenda = oView;
        this.daoVenda          = new DaoVenda();
        this.vendas            = this.daoVenda.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaVenda.getButtonBack())) {
            this.viewPesquisaVenda.dispose();
        }
    }

    public void pesquisar() {
        String sCliente = this.viewPesquisaVenda.getTextFieldPesquisa().getText();
        this.vendas     = this.daoVenda.findVendas(sCliente);
        this.viewPesquisaVenda.addRows(this.daoVenda.getVendas(this.vendas));
    }
    
    protected void select() {
        int iIndex  = this.viewPesquisaVenda.getTable().getSelectedRow();
        int iVendas = this.vendas.size();
        if ((iIndex >= 0) 
            && (iIndex < iVendas)) {
            this.viewPesquisaVenda.getViewParent().setVenda(this.vendas.get(iIndex));
            this.viewPesquisaVenda.dispose();
        }else {
            new ViewErro(this.viewPesquisaVenda, "Selecione uma Venda!").setVisible(true);
            this.viewPesquisaVenda.getTextFieldPesquisa().requestFocus();
        }
    }
}