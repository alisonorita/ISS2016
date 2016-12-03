package visao.operacoes;

import controller.visao.operacoes.ControllerViewOperacaoEfetuarDevolucao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import visao.View;
import visao.estruturais.ViewMenu;

/**
 * Classe responsavel por definir a Interface de Devolucao de uma Venda no Sistema.
 * @author  Hadyne
 */
public final class ViewOperacaoEfetuarDevolucao extends ViewOperacao {
    private JTextField jTextFieldVenda;
    private JButton    jButtonSearchVenda;
    
    private JTextField jTextFieldTotalItens;
    private JTextField jTextFieldValorTotal;

    
    private final ViewMenu viewMenu;
    
    public ViewOperacaoEfetuarDevolucao(View oViewParent) {
        super(oViewParent);
        this.viewMenu   = (ViewMenu) oViewParent;
        this.controller = new ControllerViewOperacaoEfetuarDevolucao(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Efetuar Devolucao");
        this.setSize(450, 500);
        this.setLocation(370, 125);
        this.addHeader();
        this.addComponents();
        this.clear();
    }
    
    @Override
    public void addHeader() {
        super.addHeader("efetuar_devolucao.jpg");
    }

    @Override
    public void addComponents() {
        this.jTextFieldVenda    = this.createTextField(25);
        this.jTextFieldVenda.setEditable(false);
        this.jButtonSearchVenda = this.createButton("", "search2.jpg");
        this.add(new JLabel("Venda: "));
        this.add(this.jTextFieldVenda);
        this.add(this.jButtonSearchVenda);
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Descricao", "Quantidade", "Preço"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {50, 10, 10};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.jTextFieldTotalItens = this.createTextField(10);
        this.jTextFieldTotalItens.setText("0");
        this.jTextFieldTotalItens.setEditable(false);
        this.jTextFieldValorTotal      = this.createTextField(10);
        this.jTextFieldValorTotal.setText("0.00");
        this.jTextFieldValorTotal.setEditable(false);
        
        this.add(new JLabel("Total Itens: "));
        this.add(this.jTextFieldTotalItens);
        this.add(new JLabel("   "));
        this.add(new JLabel("Valor Total"));
        this.add(this.jTextFieldValorTotal);
        
        this.addLinhas(1);
        
        this.addButtons();
    }
    
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("Confirmar", "ok.jpg");
        this.jButtonAction2 = this.createButton(" Cancelar", "exit.jpg");
        this.jButtonAction3 = this.createButton(""         , "help.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
    
    @Override
    public void clear() {
        
        this.jTextFieldVenda.setText("");
        this.jTextFieldTotalItens.setText("0");
        this.jTextFieldValorTotal.setText("0.00");
        this.clearTable();
    }
    
    public JButton getButtonSearchVenda() {
        return this.jButtonSearchVenda;
    }

    public JButton getButtonConfirmar() {
        return this.jButtonAction1;
    }

    public JButton getButtonCancelar() {
        return this.jButtonAction2;
    }

    public JButton getButtonAjuda() {
        return this.jButtonAction3;
    }

  

}