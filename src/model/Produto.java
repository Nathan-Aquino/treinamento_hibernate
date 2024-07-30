package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_seq")
    @SequenceGenerator(name = "produtos_seq",sequenceName = "seq_produtos", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Integer preco;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @OneToMany(mappedBy = "produto")
    private List<VendaProduto> saidaProduto;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<VendaProduto> getSaidaProduto() {
        return saidaProduto;
    }

    public void setSaidaProduto(List<VendaProduto> saidaProduto) {
        this.saidaProduto = saidaProduto;
    }
}
