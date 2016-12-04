package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoGerenciarEncomenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.dao.relacionais.saida.DaoItemVenda;
import modelo.estruturais.Usuario;
import modelo.relacionais.saida.ItemVenda;
import modelo.relacionais.saida.Venda;
import visao.View;
import visao.estruturais.ViewMenu;

/**
 * Classe responsavel por definir a Interface de Gerenciamento de Encomendas do Sistema.
 * @author  Marcos
 */
public final class ViewOperacaoGerenciarEncomenda extends ViewOperacao {
    private JTextField jTextFieldVenda;
    private JButton    jButtonSearchEncomenda;
    
    private JTextField jTextFieldQuantidadeTotal;
    private JTextField jTextFieldValorTotal;
    private JTextField jTextFieldCliente;
    private JTextField jTextFieldEnderecoCliente;
    
    private Venda      venda;
    private DaoItemVenda daoItemVenda;
    
    private List<ItemVenda> itens;
    private final ViewMenu viewMenu;
    
    public ViewOperacaoGerenciarEncomenda(View oViewParent) {
        super(oViewParent);
        this.viewMenu   = (ViewMenu) oViewParent;
        this.controller = new ControllerViewOperacaoGerenciarEncomenda(this);
        this.itens      = new ArrayList<>();
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Gerenciar Encomenda");
        this.setSize(450, 585);
        this.setLocation(370, 85);
        this.addHeader();
        this.addComponents();
        this.addButtons();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("gerenciar_encomenda.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldVenda    = this.createTextField(25);
        this.jTextFieldVenda.setEditable(false);
        this.jButtonSearchEncomenda = this.createButton("", "search2.jpg");
        this.add(new JLabel("Venda: "));
        this.add(this.jTextFieldVenda);
        this.add(this.jButtonSearchEncomenda);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Descricao", "Quantidade", "Preço"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {50, 10, 10};
        this.setColumnSize(iColumns);
        
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
        
        this.jTextFieldCliente         = this.createTextField(25);
        this.jTextFieldCliente.setEditable(false);
        this.add(new JLabel("    Cliente: "));
        this.add(this.jTextFieldCliente);
        
        this.addLinhas(1);
        
        this.jTextFieldEnderecoCliente = this.createTextField(25);
        this.jTextFieldEnderecoCliente.setEditable(false);
        this.add(new JLabel("Endereco: "));
        this.add(this.jTextFieldEnderecoCliente);
        
        this.addLinhas(1);
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("   Ok   ", "ok.jpg");
        this.jButtonAction2 = this.createButton(" Voltar ", "back.jpg");
        this.jButtonAction3 = this.createButton(""        , "help.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }

    @Override
    public void clear() {
        this.venda = null;
        this.itens = new ArrayList<>();
        
        this.jTextFieldVenda.setText("");
        this.clearTable();
        this.jTextFieldQuantidadeTotal.setText("0");
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldCliente.setText("");
        this.jTextFieldEnderecoCliente.setText("");
    }

    public JButton getButtonSearchEncomenda() {
        return this.jButtonSearchEncomenda;
    }

    public JButton getButtonOk() {
        return this.jButtonAction1;
    }

    @Override
    public JButton getButtonBack() {
        return this.jButtonAction2;
    }
    
    public JButton getButtonAjuda() {
        return this.jButtonAction3;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda oVenda) {
        this.daoItemVenda = new DaoItemVenda();
        this.venda        = oVenda;
        this.itens        = this.daoItemVenda.getItens(oVenda);
        
        this.jTextFieldVenda.setText(this.venda.toString());
        
        this.addRows(this.daoItemVenda.getItensVenda(this.itens));
        
        this.jTextFieldQuantidadeTotal.setText(Integer.toString(oVenda.getNumeroItens()));
        this.jTextFieldValorTotal.setText(Float.toString(oVenda.getValorTotal()));
        
        this.jTextFieldCliente.setText(this.venda.getCliente().getNome());
        this.jTextFieldEnderecoCliente.setText(this.venda.getCliente().getEndereco());
        
    }
    
    public Usuario getUsuario() {
        return this.viewMenu.getUsuario();
    }
}