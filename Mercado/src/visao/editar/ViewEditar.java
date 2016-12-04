package visao.editar;

import funct.FunctFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.estruturais.Usuario;
import visao.InterfaceView;
import visao.ViewModal;
import visao.consulta.ViewConsulta;

/**
 * Classe responsavel por definir a Interface de Edicao do Sistema.
 * @author  Marcos
 */
public abstract class ViewEditar extends ViewModal implements InterfaceView {
    private JLabel header;
    private final ViewConsulta viewConsulta;

    /**
     * Metodo construtor, que recebe como parametro a View Parent.
     * @param   oView View Parent
     */
    public ViewEditar(ViewModal oView) {
        super(oView);
        this.viewConsulta = (oView instanceof ViewConsulta) ? (ViewConsulta) oView : null;
    }
    
    /**
     * Metodo responsavel por adicionar o cabecalho padrao a um Frame de Cadastro.
     * @param   sUrlImage URL do Arquivo.
     */
    protected void addHeader(String sUrlImage) {
        this.addLinhas(1);
        this.header  = new JLabel(new FunctFrame().createImage("editar/" + sUrlImage));
        this.add(this.header);
        this.addLinhas(1);
    }
    
    /**
     * Metodo responsavel por adicionar os botoes padroes para a View de Cadastro.
     */
    @Override
    public void addButtons() {
        this.jButtonAction1 = this.createButton("  Gravar  ", "save.jpg");
        this.jButtonAction2 = this.createButton(" Cancelar ", "exit.jpg");
        this.jButtonAction3 = this.createButton(""          , "help.jpg");
        
        this.add(this.jButtonAction1);
        this.add(this.jButtonAction2);
        this.add(this.jButtonAction3);
    }
    
    @Override
    public abstract void initComponents();
    
    @Override
    public abstract void addComponents();
    
    /**
     * Metodo responsavel por limpar os componentes da View.
     */
    public void clear() {}
    
    /**
     * Metodo responsavel por retornar o Botao Salvar da View Editar.
     * @return  JButton
     */
    public JButton getButtonSave() {
        return this.jButtonAction1;
    }
    
    /**
     * Metodo responsavel por retornar o Botao Cancelar da View Editar.
     * @return  JButton
     */
    public JButton getButtonCancel() {
        return this.jButtonAction2;
    }
    
    /**
     * Metodo responsavel por retornar o Botao Ajuda da View Editar.
     * @return  JButton
     */
    public JButton getButtonAjuda() {
        return this.jButtonAction3;
    }
    
    public Usuario getUsuario() {
        return this.viewConsulta.getUsuario();
    }
}