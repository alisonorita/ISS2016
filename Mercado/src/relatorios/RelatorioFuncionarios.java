package relatorios;

import java.io.IOException;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * @author Felippe
 */
public class RelatorioFuncionarios extends Relatorio {
    
    public RelatorioFuncionarios() throws JRException, SQLException, IOException {
        super();
        this.relatorio += "relatorioFuncionarios.jrxml";
        this.gerarRelatorio();
    }
}
