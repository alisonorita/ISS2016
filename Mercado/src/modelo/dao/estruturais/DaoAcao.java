package modelo.dao.estruturais;

import java.util.List;
import modelo.dao.Dao;
import modelo.estruturais.Acao;

/**
 * <p>Classe Dao da Classe de Modelo <b>Acao</b>.</p>
 * <p>Classe responsavel pelas operacoes entre a classe Acao e o BD.</p>
 * @author  Alison
 * @see     modelo.dao.Dao
 * @see     modelo.estruturais.Operacao
 */
public class DaoAcao extends Dao<Acao> {

    /**
     * Metodo construtor padrão.
     * Define a Classe do Modelo Acao como Entidade da superclasse Dao.
     */
    public DaoAcao() {
        super(Acao.class);
        this.loadAcoes();
    }
    
    /**
     * Metodo responsavel por retornar a Acao pela Descricao.
     * @param  sDescricao Descricao da Acao.
     * @return Acao encontrada.
     */
    public Acao findAcaoByDescricao(String sDescricao) {
        String     sSql   = "SELECT e FROM Acao e WHERE e.descricao LIKE '" + sDescricao.toUpperCase() + "'";
        List<Acao> oAcoes = (List<Acao>) acesso.createQuery(sSql).getResultList();
        return (oAcoes.isEmpty() == true) ? null : oAcoes.get(0);
    }
    
    /**
     * Metodo responsavel por carregar as Acoes do Sistema.
     */
    public void loadAcoes() {
        if (this.size() == 0) {
            this.insert(new Acao(1L, "LOGIN"));
            this.insert(new Acao(2L, "LOGOFF"));
            this.insert(new Acao(3L, "SAIR"));
            
            // Cadastros:
            
            // 1 - Usuario:
            this.insert(new Acao(4L, "CADASTRO DE USUARIO"));
            this.insert(new Acao(5L, "ALTERACAO DE USUARIO"));
            this.insert(new Acao(6L, "REMOCAO DE USUARIO"));
            
            // 2 - Funcionario:            
            this.insert(new Acao(7L, "CADASTRO DE FUNCIONARIO"));
            this.insert(new Acao(8L, "ALTERACAO DE FUNCIONARIO"));
            this.insert(new Acao(9L, "REMOCAO DE FUNCIONARIO"));
            
            // 3 - Cidade:
            this.insert(new Acao(10L, "CADASTRO DE CIDADE"));
            this.insert(new Acao(11L, "ALTERACAO DE CIDADE"));
            this.insert(new Acao(12L, "REMOCAO DE CIDADE"));
            
            // 4 - Despesa:
            this.insert(new Acao(13L, "CADASTRO DE DESPESA"));
            this.insert(new Acao(14L, "ALTERACAO DE DESPESA"));
            this.insert(new Acao(15L, "REMOCAO DE DESPESA"));
            
            // 5 - Cliente:
            this.insert(new Acao(16L, "CADASTRO DE CLIENTE"));
            this.insert(new Acao(17L, "ALTERACAO DE CLIENTE"));
            this.insert(new Acao(18L, "REMOCAO DE CLIENTE"));
            
            // 6 - Fornecedor:
            this.insert(new Acao(19L, "CADASTRO DE FORNECEDOR"));
            this.insert(new Acao(20L, "ALTERACAO DE FORNECEDOR"));
            this.insert(new Acao(21L, "REMOCAO DE FORNECEDOR"));
            
            // 7 - Marca:
            this.insert(new Acao(22L, "CADASTRO DE MARCA"));
            this.insert(new Acao(23L, "ALTERACAO DE MARCA"));
            this.insert(new Acao(24L, "REMOCAO DE MARCA"));
            
            // 8 - Produto:
            this.insert(new Acao(25L, "CADASTRO DE PRODUTO"));
            this.insert(new Acao(26L, "ALTERACAO DE PRODUTO"));
            this.insert(new Acao(27L, "REMOCAO DE PRODUTO"));
            
            
            // Operacoes:
            
            this.insert(new Acao(28L, "REGISTRO DE PEDIDO"));
            this.insert(new Acao(29L, "CHEGADA DE PEDIDO"));
            this.insert(new Acao(30L, "NOTIFICACAO"));
            this.insert(new Acao(31L, "VENDA"));
            this.insert(new Acao(32L, "DEVOLUCAO"));
            this.insert(new Acao(33L, "ENCOMENDA"));
        }
    }
}