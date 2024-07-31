package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBD {
    private static EntityManager gerenciador;

    private ConexaoBD () {
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory("treinamento_hibernate");
        gerenciador = fabricaDeGerenciador.createEntityManager();
    }

    public static EntityManager getGerenciador () {
        if (gerenciador == null) {
            new ConexaoBD();
        }

        return gerenciador;
    }
}
