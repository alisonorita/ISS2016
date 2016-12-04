package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda na View de Chegada de Pedido.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaChegadaPedido extends ViewAjuda {

    public ViewAjudaChegadaPedido(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Chegada Pedido");
        this.setSize(360, 320);
        this.setLocation(410, 210);
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione um Pedido"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Para Confirmar a Chegada do Pedido, Clique em Confirmar"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}