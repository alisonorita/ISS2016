package visao.cadastro;

import controller.visao.cadastro.ControllerViewCadastroProduto;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.gerenciais.DaoMarca;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Cadastro de Produtos no Sistema.
 * @author  Marcos
 * @see     visao.cadastro.ViewCadastro
 */
public final class ViewCadastroProduto extends ViewCadastro {
    private JTextField jTextFieldDescricao;
    private JTextField jTextFieldPeso;
    private JTextField jTextFieldQuantidade;
    private JTextField jTextFieldPrecoUnitario;
    private JComboBox  jComboBoxMarca;

    public ViewCadastroProduto(View oView) {
        super(oView);
        this.controller = new ControllerViewCadastroProduto(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Cadastro de Produto");
        this.setSize(400, 405);
        this.setLocation(400, 175);
        this.addHeader();
        this.addComponents();
        this.addButtons();
    }
    
    @Override
    public void addHeader() {
        this.addHeader("cadastro_produto.jpg");
        this.message = new JLabel("Os campos com (*) sao obrigatorios!");
        this.add(this.message);
        this.addLinhas(1);
    }

    @Override
    public void addComponents() {
        this.jTextFieldDescricao     = this.createTextField(25);
        this.add(new JLabel("Descrição*: "));
        this.add(this.jTextFieldDescricao);
        
        this.addLinhas(1);
        
        String[] sMarcas    = new DaoMarca().getMarcas();
        this.jComboBoxMarca = new JComboBox(sMarcas);
        this.jComboBoxMarca.addKeyListener(this.controller);
        this.jComboBoxMarca.setPreferredSize(new Dimension(200, 20));
        this.add(new JLabel("Marca: "));
        this.add(this.jComboBoxMarca);
           
        this.jTextFieldPeso          = this.createTextField(5);
        this.add(new JLabel("  Peso: "));
        this.add(this.jTextFieldPeso);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidade    = this.createTextField(4);
        this.jTextFieldQuantidade.setText("0");
        this.jTextFieldQuantidade.setEditable(true);
        this.add(new JLabel("Quantidade*: "));
        this.add(this.jTextFieldQuantidade);
        
        this.jTextFieldPrecoUnitario = this.createTextField(8);
        this.jTextFieldPrecoUnitario.setText("0.00");
        this.add(new JLabel("         "));
        this.add(new JLabel("Preço Unitário*: "));
        this.add(this.jTextFieldPrecoUnitario);
        
        this.addLinhas(1);
    }

    @Override
    public void clear() {
        this.jTextFieldDescricao.setText("");
        this.jComboBoxMarca.setSelectedIndex(0);
        this.jTextFieldPeso.setText("");
        this.jTextFieldQuantidade.setText("0");
        this.jTextFieldPrecoUnitario.setText("0.00");
        this.jTextFieldDescricao.requestFocus();
    }

    public JTextField getTextFieldDescricao() {
        return this.jTextFieldDescricao;
    }

    public JTextField getTextFieldPeso() {
        return this.jTextFieldPeso;
    }

    public JTextField getTextFieldQuantidade() {
        return this.jTextFieldQuantidade;
    }

    public JTextField getTextFieldPrecoUnitario() {
        return this.jTextFieldPrecoUnitario;
    }

    public JComboBox getjComboBoxMarca() {
        return this.jComboBoxMarca;
    }
}