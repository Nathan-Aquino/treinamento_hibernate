package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendas_seq")
    @SequenceGenerator(name = "vendas_seq",sequenceName = "seq_vendas", allocationSize = 1, initialValue = 1)
    private Integer id;

    @OneToOne(mappedBy = "compra")
    private Cliente cliente;

    @OneToMany(mappedBy = "venda")
    private List<VendaProduto> produtos;

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<VendaProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<VendaProduto> produtos) {
        this.produtos = produtos;
    }
}
