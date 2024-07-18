import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "acessorios")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorios_seq")
    @SequenceGenerator(name = "acessorios_seq", sequenceName = "seq_acessorios", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "acessorios")
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
