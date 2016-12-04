package modelo.relacionais.entrada;

import funct.FunctDate;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;

/**
 * <p>Classe de <b>Modelo</b> Entrada.</p>
 * <p>Classe responsavel por representar as Entradas de Pedidos do Sistema.</p>
 * @author  Hadyne
 */
@Entity
@Table (name = "entrada")
@TableGenerator (name = "entrada_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "entrada", allocationSize = 1)
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "entrada_generator")
    @Column (name = "id")
    private Long   id;
    @OneToOne
    private Pedido pedido;
    @Column (name = "nota_fiscal")
    private String notaFiscal;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private final Date dataCadastro;
    @Column (name = "hora_cadastro")
    private final Time horaCadastro;
    
    public Entrada() {
        this.id           = null;
        this.dataCadastro = new FunctDate().getCurrentDate();
        this.horaCadastro = new FunctDate().getCurrentTime();
    }
    
    public Entrada(Pedido oPedido, String sNotaFiscal) {
        this();
        this.pedido     = oPedido;
        this.notaFiscal = sNotaFiscal.toUpperCase().trim();
        this.pedido.setRecebido(true);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido oPedido) {
        this.pedido = oPedido;
    }

    public String getNotaFiscal() {
        return this.notaFiscal;
    }

    public void setNotaFiscal(String sNotaFiscal) {
        this.notaFiscal = sNotaFiscal.toUpperCase().trim();
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public Time getHoraCadastro() {
        return this.horaCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof Entrada)) {
            return false;
        }
        Entrada oEntrada = (Entrada) oObject;
        return Objects.equals(this.id, oEntrada.getId());
    }

    @Override
    public String toString() {
        return this.pedido.toString() + " " + new FunctDate().getFormattedDate(this.dataCadastro);
    }
}