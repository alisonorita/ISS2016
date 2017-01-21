package controller.visao.editar;

import controller.modelo.cadastrais.ControllerProduto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.editar.ViewEditarProduto;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.gerenciais.DaoMarca;
import modelo.estruturais.Operacao;
import modelo.gerenciais.Marca;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewEditarProduto.
 * @author  Marcos
 * @see     controller.visao.editar.ControllerViewEditar
 */
public class ControllerViewEditarProduto extends ControllerViewEditar {
    private final ViewEditarProduto viewEditarProduto;
    private final ControllerProduto controllerProduto;
    private final DaoProduto        daoProduto;
    
    /**
     * Metodo construtor da Classe. 
     * @param oView
     */
    public ControllerViewEditarProduto(ViewEditarProduto oView) {
        super(oView);
        this.viewEditarProduto = oView;
        this.controllerProduto = new ControllerProduto();
        this.daoProduto        = new DaoProduto();
    }

    @Override
    public void actionPerformed(ActionEvent oActionEvent) {
        super.actionPerformed(oActionEvent);
    }
    
    @Override
    public void keyPressed(KeyEvent oKeyEvent) {
        super.keyPressed(oKeyEvent);
    }

    @Override
    protected void save() {
        String sDescricao     = this.viewEditarProduto.getTextFieldDescricao().getText().toUpperCase().trim();
        String sMarca         = this.viewEditarProduto.getjComboBoxMarca().getSelectedItem().toString();
        String sPeso          = this.viewEditarProduto.getTextFieldPeso().getText().trim();
        String sQuantidade    = this.viewEditarProduto.getTextFieldQuantidade().getText().toUpperCase().trim();
        String sPrecoUnitario = this.viewEditarProduto.getTextFieldPrecoUnitario().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sQuantidade, sPrecoUnitario)== true) {
            Marca   oMarca         = new DaoMarca().findMarcaByNome(sMarca);
            int     iQuantidade    = Integer.parseInt(sQuantidade);
            float   fPrecoUnitario = Float.parseFloat(sPrecoUnitario);
            Produto oProduto       = this.viewEditarProduto.getProduto();
                    oProduto.setDescricao(sDescricao);
                    oProduto.setMarca(oMarca);
                    oProduto.setPeso(sPeso);
                    oProduto.setQuantidade(iQuantidade);
                    oProduto.setPrecoUnitario(fPrecoUnitario);
            this.daoProduto.update(oProduto);
            new DaoOperacao().insert(new Operacao("Produto = " + oProduto.getId(), new DaoAcao().get(26L), this.viewEditarProduto.getUsuario()));
            new ViewMensagem(this.viewEditarProduto, "Produto Atualizado com Sucesso!").setVisible(true);
            this.viewEditarProduto.dispose();
            this.viewEditarProduto.getViewConsultaProduto().clear();
        }
    }
    
    private boolean checkParameters(String sDescricao, String sQuantidade, String sPrecoUnitario) {
        if (this.controllerProduto.checkDescricao(sDescricao) == false) {
            new ViewErro(this.viewEditarProduto, "Descricao Inválida!").setVisible(true);
            this.viewEditarProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.checkQuantidade(sQuantidade) == false) {
            new ViewErro(this.viewEditarProduto, "Quantidade Inválida!").setVisible(true);
            this.viewEditarProduto.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (this.controllerProduto.checkPrecoUnitario(sPrecoUnitario) == false) {
            new ViewErro(this.viewEditarProduto, "Preco Unitario Inválido!").setVisible(true);
            this.viewEditarProduto.getTextFieldPrecoUnitario().requestFocus();
            return false;
        }else if (this.controllerProduto.checkUpdate(sDescricao, this.viewEditarProduto.getProduto().getId()) == false) {
            new ViewErro(this.viewEditarProduto, "Produto já Cadastrado!").setVisible(true);
            this.viewEditarProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.viewEditarProduto.getjComboBoxMarca().getSelectedIndex() == 0) {
            new ViewErro(this.viewEditarProduto, "Selecione uma Marca!").setVisible(true);
            this.viewEditarProduto.getjComboBoxMarca().requestFocus();
            return false;
        }
        
        return true;
    }
}