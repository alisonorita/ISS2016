package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoGerenciarProduto;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Produto;
import modelo.dao.relacionais.entrada.DaoItemPedido;
import visao.View;

/**
 * Classe responsavel por definir a Interface para Gerenciar Produtos do Sistema.
 * @author  Marcos
 */
public final class ViewOperacaoGerenciarProduto extends ViewOperacao {
    private JTextField    jTextFieldProduto;
    private JButton       jButtonSearchProduto;
    private JTextField    jTextFieldQuantidadeComprada;
    private JTextField    jTextFieldQuantidadeEstoque;
    private JTextField    jTextFieldQuantidadeVendida;
    private Produto       produto;
    private DaoItemPedido daoItemPedido;
   
    private JButton       jButtonAjuda;

    public ViewOperacaoGerenciarProduto(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewOperacaoGerenciarProduto(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Gerenciar Produto");
        this.setSize(450, 400);
        this.setLocation(370, 175);
        this.addHeader();
        this.addComponents();
        this.addButtons();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("gerenciar_produto.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldProduto = this.createTextField(25);
        this.jTextFieldProduto.setEditable(false);
        this.add(new JLabel("Produto: "));
        this.add(this.jTextFieldProduto);        
        this.jButtonAction1 = this.createButton("", "search2.jpg");
        this.add(this.jButtonAction1);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeComprada  = new JTextField(10);
        this.jTextFieldQuantidadeComprada.setEditable(false);
        this.add(new JLabel("   Quantidade Comprada: "));
        this.add(this.jTextFieldQuantidadeComprada);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeEstoque  = new JTextField(10);
        this.jTextFieldQuantidadeEstoque.setEditable(false);
        this.add(new JLabel("Quantidade Em Estoque: "));
        this.add(this.jTextFieldQuantidadeEstoque);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeVendida  = new JTextField(10);
        this.jTextFieldQuantidadeVendida.setEditable(false);
        this.add(new JLabel("      Quantidade Vendida: "));
        this.add(this.jTextFieldQuantidadeVendida);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction2 = this.createButton("  Ok  ", "ok.jpg");
        this.jButtonAction3 = this.createButton("Voltar", "back.jpg");
        this.jButtonAjuda   = this.createButton(""      , "help.jpg");
        
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
        this.add(this.jButtonAjuda);
    }

    @Override
    public void clear() {}

    public void setProduto(Produto oProduto) {
        this.produto       = oProduto;
        this.daoItemPedido = new DaoItemPedido();
        
        
        this.jTextFieldProduto.setText(this.produto.toString());
        this.jTextFieldQuantidadeComprada.setText(Integer.toString(this.daoItemPedido.getQuantidadeComprada(this.produto)));
        this.jTextFieldQuantidadeEstoque.setText(Integer.toString(this.produto.getQuantidade()));
        
    }
    
    public JButton getButtonSearchProduto() {
        return this.jButtonAction1;
    }

    public JButton getButtonOk() {
        return this.jButtonAction2;
    }

    public JButton getButtonVoltar() {
        return this.jButtonAction3;
    }

    public JButton getButtonAjuda() {
        return this.jButtonAjuda;
    }
}