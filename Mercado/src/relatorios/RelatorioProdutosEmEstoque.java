package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe responsavel por definir os parametros do Relatorio de Produtos em Estoque.
 */
public class RelatorioProdutosEmEstoque extends Relatorio {
    
    public RelatorioProdutosEmEstoque() throws JRException, IOException, SQLException {
        super();
        this.relatorio += "relatorioProdutosEstoque.jrxml";
        try{
            this.gerarRelatorio();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}