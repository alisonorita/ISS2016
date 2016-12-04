package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaVenda;
import javax.swing.JLabel;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoEfetuarDevolucao;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Vendas no Sistema.
 * @author  Hadyne
 * @version 1.0
 * @since   17/01/2016
 */
public final class ViewPesquisaVenda extends ViewPesquisa {
    private final ViewOperacaoEfetuarDevolucao viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oViewParent 
     */
    public ViewPesquisaVenda(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = (ViewOperacaoEfetuarDevolucao) oViewParent;
        this.controller = new ControllerViewPesquisaVenda(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Vendas");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_venda.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Cliente: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Cliente", "Data", "Valor"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {195, 100, 100};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        ((ControllerViewPesquisaVenda) this.controller).pesquisar();
    }

    public ViewOperacaoEfetuarDevolucao getViewParent() {
        return this.viewParent;
    }
}