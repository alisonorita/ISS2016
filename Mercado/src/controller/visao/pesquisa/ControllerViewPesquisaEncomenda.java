package controller.visao.pesquisa;

import controller.visao.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.util.List;
import modelo.dao.relacionais.saida.DaoVenda;
import modelo.relacionais.saida.Venda;
import visao.mensagens.ViewErro;
import visao.pesquisa.ViewPesquisaEncomenda;

/**
 * Classe responsavel por definir o controlador da View de Pesquisa de Fornecedores.
 * @author  Marcos
 */
public class ControllerViewPesquisaEncomenda extends ControllerViewModal {
    private final ViewPesquisaEncomenda viewPesquisaEncomenda;
    private final DaoVenda              daoVenda;
    private       List<Venda>           vendas;

    public ControllerViewPesquisaEncomenda(ViewPesquisaEncomenda oView) {
        super(oView);
        this.viewPesquisaEncomenda = oView;
        this.daoVenda              = new DaoVenda();
        this.vendas                = this.daoVenda.list();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        if (oActionEvent.getSource().equals(this.viewPesquisaEncomenda.getButtonPesquisa())) {
            this.pesquisar();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaEncomenda.getButtonSelect())) {
            this.select();
        }else if (oActionEvent.getSource().equals(this.viewPesquisaEncomenda.getButtonBack())) {
            this.viewPesquisaEncomenda.dispose();
        }
    }

    public void pesquisar() {
        String sCliente = this.viewPesquisaEncomenda.getTextFieldPesquisa().getText();
        this.vendas     = this.daoVenda.findVendas(sCliente);
        this.viewPesquisaEncomenda.addRows(this.daoVenda.getVendas(this.vendas));
    }
    
    protected void select() {
        int iIndex  = this.viewPesquisaEncomenda.getTable().getSelectedRow();
        int iVendas = this.vendas.size();
        if ((iIndex >= 0) 
            && (iIndex < iVendas)) {
            this.viewPesquisaEncomenda.getViewParent().setVenda(this.vendas.get(iIndex));
            this.viewPesquisaEncomenda.dispose();
        }else {
            new ViewErro(this.viewPesquisaEncomenda, "Selecione uma Venda!").setVisible(true);
            this.viewPesquisaEncomenda.getTextFieldPesquisa().requestFocus();
        }
    }
}