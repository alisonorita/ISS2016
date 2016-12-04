package visao.consulta;

import controller.visao.consulta.ControllerViewConsultaFornecedor;
import javax.swing.JLabel;
import visao.View;

/**
 * Classe responsavel por definir a Interface de Consulta de Fornecedores do Sistema.
 * @author  Marcos
 */
public final class ViewConsultaFornecedor extends ViewConsulta {

    /**
     * Metodo constrututor herdado da superclasse.
     * @param oViewParent 
     */
    public ViewConsultaFornecedor(View oViewParent) {
        super(oViewParent);
        this.controller = new ControllerViewConsultaFornecedor(this);
        this.initComponents();
    }

    @Override
    public void initComponents() {
        this.setTitle("Mercado - Consulta de Fornecedores");
        this.setSize(400, 450);
        this.setLocation(400, 150);
        this.addHeader();
        this.addComponents();
        this.clear();
    }

    @Override
    public void addHeader() {
        super.addHeader("consulta_fornecedor.jpg");
    }
    
    @Override
    public void addComponents() {
        this.add(new JLabel("Fornecedor: "));
        this.addCampos();
        
        this.addLinhas(1);
        
        this.addTable();
        
        String[] sColumns = {"Id", "Nome", "CNPJ"};
        this.setColumns(sColumns);
        
        int[]    iColumns = {75, 160, 160};
        this.setColumnSize(iColumns);
        
        this.addLinhas(1);
        
        this.addButtons();
    }

    @Override
    public void clear() {
        this.jTextFieldPesquisa.setText("");
        this.jTextFieldPesquisa.requestFocus();
        ((ControllerViewConsultaFornecedor) this.controller).pesquisar();
    }
}