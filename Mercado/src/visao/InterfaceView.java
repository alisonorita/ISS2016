package visao;

/**
 * <p>Interface View.</p>
 * <p>Define as Operacoes Principais das Classes de Visao modais.</p>
 * <p>Todos os metodos possuem uma especificacao acima da assinatura.</p>
 */
public interface InterfaceView {
    
    /**
     * Metodo responsavel por definir configuracoes adicionais a View e chamar 
     * os metodos responsaveis por carregar os elementos da View.
     */
    public void initComponents();
     
    /**
     * Metodo responsavel por adicionar o cabecalho de uma View.

     */
    public void addHeader();
    
    /**
     * Metodo responsavel por adicionar os componentes de uma View.
     */
    public void addComponents();
    
    /**
     * Metodo responsavel por adicionar os botoes de uma View.
     */
    public void addButtons();
}