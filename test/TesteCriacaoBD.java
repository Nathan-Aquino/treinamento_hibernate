import model.Cliente;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriacaoBD {
    @Test
    public void criaCliente () {
        String teste = "teste";
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory("treinamento_hibernate");

        EntityManager gerenciador = fabricaDeGerenciador.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setNome("Teste");
        cliente.setIdade(33);
        cliente.setEmail("teste@teste.com");

        gerenciador.getTransaction().begin();
        gerenciador.persist(cliente);
        gerenciador.getTransaction().commit();

        gerenciador.close();
        fabricaDeGerenciador.close();
    }
}
