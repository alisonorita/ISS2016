package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaDespesa;
import javax.swing.JLabel;
import modelo.dao.gerenciais.DaoDespesa;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Despesas do Sistema.
 * @author  Alison
 */
public final class ViewConsultaDespesa extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @since  22/10/2015
     * @param oViewParent 
     */
    public ViewConsultaDespesa(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaDespesa(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Despesas");
        this.setSize(400, 450);
        this.setLocation(400, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_despesa.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Despesa: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Descricao", "Valor"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 240, 85};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        
        this.addRows(new DaoDespesa().getDespesas(new DaoDespesa().list()));
    }
}