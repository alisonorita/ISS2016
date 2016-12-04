package controller.visao.estruturais;

import java.awt.event.ActionEvent;
import controller.visao.ControllerView;
import visao.cadastro.ViewCadastroProduto;
import visao.cadastro.ViewCadastroDespesa;
import visao.cadastro.ViewCadastroUsuario;
import visao.consulta.ViewConsultaProduto;
import visao.consulta.ViewConsultaUsuario;
import visao.estruturais.ViewMenu;


/**
 * Classe responsavel por ser o <b>controlador</b> da ViewMenu.
 * @author  Marcos
 * @see     controller.visao.ControllerView
 */
public class ControllerViewMenu extends ControllerView {
    private final ViewMenu viewMenu;
    
    /**
     * Metodo construtor da Classe.
     * @param oView 
     */
    public ControllerViewMenu(ViewMenu oView) {
        super(oView);
        this.viewMenu = oView;
    }

    @Override
    public void actionPerformed(ActionEvent oEvento) {
        if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroUsuario())) {
            new ViewCadastroUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaUsuario())) {
            new ViewConsultaUsuario(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroProduto())) {
            new ViewCadastroProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemConsultaProduto())) {
            new ViewConsultaProduto(this.viewMenu).setVisible(true);
        }else if (oEvento.getSource().equals(this.viewMenu.getMenuItemCadastroDespesa())) {
            new ViewCadastroDespesa(this.viewMenu).setVisible(true);
        }
    }
}