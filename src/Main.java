import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory("treinamento_hibernate");

        EntityManager gerenciador = fabricaDeGerenciador.createEntityManager();

        List<Carro> carros = new ArrayList<>();
        List<Acessorio> acessorios = new ArrayList<>();

        Marca marca = new Marca();
        marca.setNome("Toyota");

        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Painel de Led");
        acessorios.add(acessorio);

        Carro carro = new Carro();
        carro.setNome("Corolla");
        carro.setMarca(marca);
        carro.setAcessorios(acessorios);
        carros.add(carro);

        acessorio.setCarros(carros);
        marca.setCarros(carros);

        gerenciador.getTransaction().begin();
        gerenciador.persist(marca);
        gerenciador.persist(carro);
        gerenciador.persist(acessorio);
        gerenciador.getTransaction().commit();

        gerenciador.close();
        fabricaDeGerenciador.close();
    }
}
