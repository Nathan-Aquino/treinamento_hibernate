import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carros_seq")
    @SequenceGenerator(name = "carros_seq", sequenceName = "seq_carros", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(
            name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id",
            nullable = false
    )
    private Marca marca;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "carros_acessorios",
            joinColumns = @JoinColumn(name = "id_carro_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio_fk")
    )
    private List<Acessorio> acessorios;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
}
