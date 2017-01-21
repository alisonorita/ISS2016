package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe responsavel por definir os parametros do Relatorio de Produtos Mais Vendidos.
 */
public class RelatorioProdutosMaisVendidos extends Relatorio {
    
    public RelatorioProdutosMaisVendidos() throws JRException, IOException, SQLException {
        super();
        this.relatorio += "relatorioProdutosMaisVendidos.jrxml";
        this.gerarRelatorio();
    }
}