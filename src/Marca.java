import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marcas_seq")
    @SequenceGenerator(name = "marcas_seq", sequenceName = "seq_marcas", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "marca")
    private List<Carro> carros;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
