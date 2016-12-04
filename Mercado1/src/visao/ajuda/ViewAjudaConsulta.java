package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda nas Views de Consulta no Sistema.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaConsulta extends ViewAjuda {

    public ViewAjudaConsulta(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Consulta");
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Selecione um Item e Clique em Editar"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Selecione um Item e Clique em Remover"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Pesquisar, Digite a palavra-chave e Atualize"));
        this.addLinhas(1);
        this.add(new JLabel("4 - Para Voltar ao Menu, Clique em Voltar"));
    }    
}