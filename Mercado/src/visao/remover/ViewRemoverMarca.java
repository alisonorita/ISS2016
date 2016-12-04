package visao.remover;

import controller.visao.remover.ControllerViewRemoverMarca;
import modelo.gerenciais.Marca;
import visao.consulta.ViewConsultaMarca;

/**
 * Classe responsavel por definir a Interface de Remocao de uma Marca do Sistema.
 * @author  Marcos
 */
public class ViewRemoverMarca extends ViewRemover {
    private final Marca marca;

    public ViewRemoverMarca(ViewConsultaMarca oView, Marca oMarca) {
        super(oView);
        this.controller  = new ControllerViewRemoverMarca(this);
        this.marca     = oMarca;
        this.initComponents();
    }
    
    private void initComponents() {
        this.setTitle("Mercado - Remover Marca");
        this.addComponents(this.marca.toString());
    }
    
    public Marca getMarca() {
        return this.marca;
    }
}