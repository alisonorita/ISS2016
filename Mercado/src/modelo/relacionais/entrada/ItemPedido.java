package modelo.relacionais.entrada;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import modelo.cadastrais.Produto;

/**
 * <p>Classe de <b>Modelo</b> ItemPedido.</p>
 * <p>Classe responsavel por representar os Itens dos Pedidos do Sistema.</p>
 * @author  Hadyne
 */
@Entity
@Table (name = "item_pedido")
@TableGenerator (name = "item_pedido_generator", table = "generator_id", pkColumnName = "id", valueColumnName = "valor", pkColumnValue = "item_pedido", allocationSize = 1)
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "item_pedido_generator")
    @Column (name = "id")
    private Long   id;
    @ManyToOne
    @JoinColumn (name = "produto_id")
    private Produto produto;
    @Column (name = "quantidade")
    private int     quantidade;
    @Column (name = "preco_unitario")
    private float   precoUnitario;
    
    public ItemPedido() {
        this.id = null;
    }
    


    public Long getId() {
        return this.id;
    }

    public void setId(Long lId) {
        this.id = lId;
    }


    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto oProduto) {
        this.produto = oProduto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int iQuantidade) {
        this.quantidade = (iQuantidade >= 0) ? iQuantidade : 0;
    }

    public float getPrecoUnitario() {
        return this.precoUnitario;
    }

    public void setPrecoUnitario(float fPrecoUnitario) {
        this.precoUnitario = (fPrecoUnitario >= 0.0) ? fPrecoUnitario : 0.0f;
    }
    
    public String[] getInfo() {
        String[] sInfo    = new String[3];
                 sInfo[0] = this.produto.getDescricao().trim();
                 sInfo[1] = Integer.toString(this.quantidade);
                 sInfo[2] = Float.toString(this.precoUnitario);
        return   sInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object oObject) {
        if (!(oObject instanceof ItemPedido)) {
            return false;
        }
        ItemPedido oItemPedido = (ItemPedido) oObject;
        return Objects.equals(this.id, oItemPedido.getId());
    }

}