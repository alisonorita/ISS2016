package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaFuncionario;
import javax.swing.JLabel;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Funcionarios do Sistema.
 * @author  Felippe
 
 */
public final class ViewConsultaFuncionario extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaFuncionario(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaFuncionario(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Funcionarios");
        this.setSize(400, 450);
        this.setLocation(400, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_funcionario.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Funcionario: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "CPF", "Nome"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 120, 200};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        ((ControllerViewConsultaFuncionario) this.controller).pesquisar();
    }
}