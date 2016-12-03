package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoEfetuarVenda;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.cadastrais.Cliente;
import visao.View;
import visao.estruturais.ViewMenu;

/**
 * Classe responsavel por definir a Interface de Venda do Sistema.
 * @author  Hadyne
 */
public final class ViewOperacaoEfetuarVenda extends ViewOperacao {
    private JTextField jTextFieldCliente;
    private JButton    jButtonSearchCliente;
    
    private JButton    jButtonAdicionarItem;
    private JButton    jButtonRemoverItem;
    
    private JTextField jTextFieldQuantidadeTotal;
    private JTextField jTextFieldValorTotal;
    
    private Cliente    cliente;
    private int        quantidade;
    private float      valorTotal;
    private final ViewMenu viewMenu;
    
    public ViewOperacaoEfetuarVenda(View oViewParent) {
        super(oViewParent);
        this.viewMenu     = (ViewMenu) oViewParent;
        this.controller   = new ControllerViewOperacaoEfetuarVenda(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Efetuar Venda");
        this.setSize(450, 530);
        this.setLocation(370, 110);
        this.addHeader();
        this.addComponents();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("efetuar_venda.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldCliente    = this.createTextField(25);
        this.jTextFieldCliente.setEditable(false);
        this.jButtonSearchCliente = this.createButton("", "search2.jpg");
        this.add(new JLabel("Cliente: "));
        this.add(this.jTextFieldCliente);
        this.add(this.jButtonSearchCliente);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Nome", "Quantidade", "Preço"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {50, 10, 10};
        this.setColumnSize(iColumns);
        
        this.jButtonAdicionarItem = this.createButton("Adicionar", "add.jpg");
        this.jButtonRemoverItem   = this.createButton(" Remover ", "exit.jpg");
        
        this.add(this.jButtonAdicionarItem);
        this.add(this.jButtonRemoverItem);
        
        this.addLinhas(1);
        
        this.jTextFieldQuantidadeTotal = this.createTextField(5);
        this.jTextFieldQuantidadeTotal.setText("0");
        this.jTextFieldQuantidadeTotal.setEditable(false);
        this.jTextFieldValorTotal      = this.createTextField(10);
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldValorTotal.setEditable(false);
        
        this.add(new JLabel("Total Itens: "));
        this.add(this.jTextFieldQuantidadeTotal);
        this.add(new JLabel("   "));
        this.add(new JLabel("Valor Total"));
        this.add(this.jTextFieldValorTotal);
        
        this.addLinhas(1);
        
        this.addButtons();
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Gravar" , "save.jpg");
        this.jButtonAction2 = this.createButton("Voltar" , "back.jpg");
        this.jButtonAction3 = this.createButton(""       , "help.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
    
    
    public void refreshTable() {
        this.jTextFieldQuantidadeTotal.setText(Integer.toString(this.quantidade));
        this.jTextFieldValorTotal.setText(Float.toString(this.valorTotal));
    }

    @Override
    public void clear() {
        this.cliente    = null;
        this.valorTotal = 0.0f;
        this.quantidade = 0;
        
        this.jTextFieldCliente.setText("");
        this.refreshTable();
    }

    public JButton getButtonSearchCliente() {
        return this.jButtonSearchCliente;
    }

    public JButton getButtonAdicionarItem() {
        return this.jButtonAdicionarItem;
    }

    public JButton getButtonRemoverItem() {
        return this.jButtonRemoverItem;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente oCliente) {
        this.cliente = oCliente;
        this.jTextFieldCliente.setText(this.cliente.toString());
    }
    
    public JButton getButtonGravar() {
        return this.jButtonAction1;
    }

    @Override
    public JButton getButtonBack() {
        return this.jButtonAction2;
    }

    public JButton getButtonAjuda() {
        return this.jButtonAction3;
    }
    

}