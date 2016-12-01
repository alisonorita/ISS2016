package visao.ajuda;

import javax.swing.JLabel;
import visao.ViewModal;

/**
 * <p>Classe responsavel por definir a Interface de Ajuda nas Views de Edicao no Sistema.</p>
 * <p>Subclasse da classe abstrata ViewAjuda.</p>
 */
public class ViewAjudaEditar extends ViewAjuda {

    public ViewAjudaEditar(ViewModal oView) {
        super(oView);
        this.setTitle("Mercado - Ajuda Editar");
        this.setSize(320, 320);
        this.setLocation(450, 210);
    }

    @Override
    protected void addComponents() {
        this.addLinhas(1);
        this.add(new JLabel("1 - Preencha os Campos Obrigatorios(*)"));
        this.addLinhas(1);
        this.add(new JLabel("2 - Apos Alterar Campos, Clique em Gravar"));
        this.addLinhas(1);
        this.add(new JLabel("3 - Para Voltar a Consulta, Clique em Voltar"));
    }    
}