import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory("treinamento_hibernate");

        EntityManager gerenciador = fabricaDeGerenciador.createEntityManager();

        Produto produto = new Produto();

        produto.setNome("Notebook");
        produto.setQuantidade(2);

        gerenciador.getTransaction().begin();
        gerenciador.persist(produto);
        gerenciador.getTransaction().commit();

        gerenciador.close();
        fabricaDeGerenciador.close();
    }
}
