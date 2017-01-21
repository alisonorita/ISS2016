package controller.visao.cadastro;

import controller.modelo.cadastrais.ControllerProduto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.cadastrais.Produto;
import modelo.dao.cadastrais.DaoProduto;
import visao.cadastro.ViewCadastroProduto;
import visao.mensagens.ViewErro;
import visao.mensagens.ViewMensagem;
import modelo.dao.estruturais.DaoAcao;
import modelo.dao.estruturais.DaoOperacao;
import modelo.dao.gerenciais.DaoMarca;
import modelo.estruturais.Operacao;
import modelo.gerenciais.Marca;

/**
 * Classe responsavel por ser o <b>controlador</b> da ViewCadastroProduto.
 * @author  Marcos
 * @see     visao.cadastro.ControllerViewCadastro
 */
public class ControllerViewCadastroProduto extends ControllerViewCadastro {
    private final ViewCadastroProduto viewCadastroProduto;
    private final ControllerProduto   controllerProduto;
    private final DaoProduto          daoProduto;
    
    /**
     * Metodo construtor da Classe.
     * @param oView
     */
    public ControllerViewCadastroProduto(ViewCadastroProduto oView) {
        super(oView);
        this.viewCadastroProduto = oView;
        this.controllerProduto   = new ControllerProduto();
        this.daoProduto          = new DaoProduto();
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
    public void cadastro() {
        String sDescricao     = this.viewCadastroProduto.getTextFieldDescricao().getText().toUpperCase().trim();
        String sMarca         = this.viewCadastroProduto.getjComboBoxMarca().getSelectedItem().toString();
        String sPeso          = this.viewCadastroProduto.getTextFieldPeso().getText().trim();
        String sQuantidade    = this.viewCadastroProduto.getTextFieldQuantidade().getText().toUpperCase().trim();
        String sPrecoUnitario = this.viewCadastroProduto.getTextFieldPrecoUnitario().getText().toUpperCase().trim();
        if (this.checkParameters(sDescricao, sQuantidade, sPrecoUnitario)== true) {
            Marca   oMarca         = new DaoMarca().findMarcaByNome(sMarca);
            int     iQuantidade    = Integer.parseInt(sQuantidade);
            float   fPrecoUnitario = Float.parseFloat(sPrecoUnitario);
            Produto oProduto       = new Produto(sDescricao, oMarca, sPeso, iQuantidade, fPrecoUnitario);
            this.daoProduto.insert(oProduto);
            this.viewCadastroProduto.clear();
            new DaoOperacao().insert(new Operacao("Produto = " + oProduto.getId(), new DaoAcao().get(25L), this.viewCadastroProduto.getUsuario()));
            new ViewMensagem(this.viewCadastroProduto, "Produto Cadastrado com Sucesso!").setVisible(true);
        }
    }
    
    private boolean checkParameters(String sDescricao, String sQuantidade, String sPrecoUnitario) {
        if (this.controllerProduto.checkDescricao(sDescricao) == false) {
            this.viewCadastroProduto.setErro("Descricao Inválida!");
            new ViewErro(this.viewCadastroProduto, "Descricao Inválida!").setVisible(true);
            this.viewCadastroProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.produtoIsAvailable(sDescricao) == false) {
            this.viewCadastroProduto.setErro("Produto já Cadastrado!");
            new ViewErro(this.viewCadastroProduto, "Produto já Cadastrado!").setVisible(true);
            this.viewCadastroProduto.getTextFieldDescricao().requestFocus();
            return false;
        }else if (this.controllerProduto.checkQuantidade(sQuantidade) == false) {
            this.viewCadastroProduto.setErro("Quantidade Inválida!");
            new ViewErro(this.viewCadastroProduto, "Quantidade Inválida!").setVisible(true);
            this.viewCadastroProduto.getTextFieldQuantidade().requestFocus();
            return false;
        }else if (this.controllerProduto.checkPrecoUnitario(sPrecoUnitario) == false) {
            this.viewCadastroProduto.setErro("Preco Unitario Inválido!");
            new ViewErro(this.viewCadastroProduto, "Preco Unitario Inválido!").setVisible(true);
            this.viewCadastroProduto.getTextFieldPrecoUnitario().requestFocus();
            return false;
        }else if (this.viewCadastroProduto.getjComboBoxMarca().getSelectedIndex() == 0) {
            this.viewCadastroProduto.setErro("Selecione uma Marca!");
            new ViewErro(this.viewCadastroProduto, "Selecione uma Marca!").setVisible(true);
            this.viewCadastroProduto.getjComboBoxMarca().requestFocus();
            return false;
        }
        return true;
    }
}