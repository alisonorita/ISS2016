package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe responsavel por definir os parametros do Relatorio de Despesas.
 * @since  10/02/2016
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