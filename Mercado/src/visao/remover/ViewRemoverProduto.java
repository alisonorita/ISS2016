package visao.remover;

import controller.visao.remover.ControllerViewRemoverProduto;
import modelo.cadastrais.Produto;
import visao.consulta.ViewConsultaProduto;

/**
 * Classe responsavel por definir a Interface de Remocao de um Produto do Sistema.
 * @author  Marcos
 */
public class ViewRemoverProduto extends ViewRemover {
     private final Produto produto;

    
    public ViewRemoverProduto(ViewConsultaProduto oView, Produto oProduto) {
        super(oView);
        this.controller  = new ControllerViewRemoverProduto(this);
        this.produto     = oProduto;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Produto");
        this.addComponents(this.produto.toString());
    }
    
    public Produto getProduto() {
        return this.produto;
    }
}