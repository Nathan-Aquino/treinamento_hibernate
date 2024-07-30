package model;

import javax.persistence.*;

@Entity
@Table(name = "vendas_produtos")
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendas_produtos_seq")
    @SequenceGenerator(name = "vendas_produtos_seq",sequenceName = "seq_vendas_produtos", allocationSize = 1, initialValue = 1)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(
            name = "id_venda_fk",
            foreignKey = @ForeignKey(name = "fk_venda"),
            referencedColumnName = "id",
            nullable = false
    )
    private Venda venda;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(
            name = "id_produto_fk",
            foreignKey = @ForeignKey(name = "fk_produto"),
            referencedColumnName = "id",
            nullable = false
    )
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
