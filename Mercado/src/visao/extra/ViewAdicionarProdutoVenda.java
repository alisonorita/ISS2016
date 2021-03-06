package visao.extra;

import controller.visao.extra.ControllerViewAdicionarProdutoVenda;
import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Produto;
import visao.InterfaceView;
import visao.ViewModal;
import visao.operacoes.ViewOperacaoEfetuarVenda;

/**
 * <p>Classe de Visao <b>ViewAdicionarProdutoVenda.</b></p>
 * <p>Subclasse da classe abstrata ViewModal.</p>
 * <p>Classe responsavel por definir a Interface de Adicionar um ItemVenda.</p>
 * @author  Hadyne
 * @see     visao.ViewModal
 */
public final class ViewAdicionarProdutoVenda extends ViewModal implements InterfaceView {
    private JTextField jTextProduto;
    private JTextField jTextFieldQuantidadeEstoque;
    private JTextField jTextFieldPrecoUnitarioProduto;
    private JTextField jTextFieldQuantidade;
    private Produto    produto;
    private final ViewOperacaoEfetuarVenda viewParent;

    public ViewAdicionarProdutoVenda(ViewModal oView) {
        super(oView);
        this.viewParent = (ViewOperacaoEfetuarVenda) oView;
        this.controller = new ControllerViewAdicionarProdutoVenda(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Adicionar Item Venda");
        this.setSize(370, 380);
        this.setLocation(400, 165);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }

    @Override
    public void addHeader() {
        this.add(new JLabel(new FunctFrame().createImage("extra/adicionar_produto.jpg")));
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextProduto   = this.createTextField(20);
        this.jTextProduto.setEditable(false);
        this.jButtonAction1 = this.createButton("", "search2.jpg");
        this.add(new JLabel("Produto: "));
        this.add(this.jTextProduto);
        this.add(this.jButtonAction1);
        
        this.addLinhas(1);
        
        this.jTextFieldPrecoUnitarioProduto = this.createTextField(5);
        this.jTextFieldPrecoUnitarioProduto.setText("0.00");
        this.add(new JLabel("Preco Unitário: "));
        this.add(this.jTextFieldPrecoUnitarioProduto);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeEstoque = this.createTextField(3);
        this.jTextFieldQuantidadeEstoque.setText("0");
        this.jTextFieldQuantidadeEstoque.setEditable(false);
        this.add(new JLabel("Quantidade no Estoque: "));
        this.add(this.jTextFieldQuantidadeEstoque);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidade = this.createTextField(3);
        this.jTextFieldQuantidade.setText("0");
        this.add(new JLabel("Quantidade: "));
        this.add(this.jTextFieldQuantidade);
        
        this.addLinhas(1);
    }

    @Override
    public void addButtons() {
        this.jButtonAction2 = this.createButton("Adicionar", "add.jpg");
        this.jButtonAction3 = this.createButton("Cancelar ", "exit.jpg");
        
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
   
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto oProduto) {
        this.produto = oProduto;
        this.jTextProduto.setText(this.produto.toString());
        this.jTextFieldQuantidadeEstoque.setText(Integer.toString(this.produto.getQuantidade()));
        this.jTextFieldPrecoUnitarioProduto.setText(Float.toString(this.produto.getPrecoUnitario()));
    }
    
    public JButton getButtonSearchProduto() {
        return this.jButtonAction1;
    }

    public JTextField getTextFieldPrecoUnitarioProduto() {
        return this.jTextFieldPrecoUnitarioProduto;
    }

    public JTextField getTextFieldQuantidade() {
        return this.jTextFieldQuantidade;
    }
    
    public JButton getButtonAdicionar() {
        return this.jButtonAction2;
    }
    
    public JButton getButtonBack() {
        return this.jButtonAction3;
    }
    
    public ViewOperacaoEfetuarVenda getViewParent() {
        return this.viewParent;
    }
}