package visao.pesquisa;

import controller.visao.pesquisa.ControllerViewPesquisaEncomenda;
import javax.swing.JLabel;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoGerenciarEncomenda;

/**
 * Classe responsavel por definir a Interface de Pesquisa de Encomendas no Sistema.
 * @author  Marcos
 */
public final class ViewPesquisaEncomenda extends ViewPesquisa {
    private final ViewOperacaoGerenciarEncomenda viewParent;

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oViewParent 
     */
    public ViewPesquisaEncomenda(ViewModal oViewParent) {
        super(oViewParent);
        this.viewParent = (ViewOperacaoGerenciarEncomenda) oViewParent;
        this.controller = new ControllerViewPesquisaEncomenda(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Pesquisa de Encomendas");
        this.setSize(370, 450);
        this.setLocation(410, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("pesquisa_encomenda.jpg");
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
        ((ControllerViewPesquisaEncomenda) this.controller).pesquisar();
    }

    public ViewOperacaoGerenciarEncomenda getViewParent() {
        return this.viewParent;
    }
}