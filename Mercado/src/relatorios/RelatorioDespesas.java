package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe responsavel por definir os parametros do Relatorio de Despesas.
 */
public class RelatorioDespesas extends Relatorio {
    
    public RelatorioDespesas() throws JRException, SQLException, IOException {
        super();
        this.relatorio += "relatorioDespesas.jrxml";
        try {
            this.gerarRelatorio();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}