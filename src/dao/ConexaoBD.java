package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBD {
    private static EntityManager gerenciador;
    private static EntityManager gerenciador2;

    private ConexaoBD () {
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory("treinamento_hibernate");
        gerenciador = fabricaDeGerenciador.createEntityManager();
    }

    private ConexaoBD (String persistenceUnit) {
        EntityManagerFactory fabricaDeGerenciador = Persistence.createEntityManagerFactory(persistenceUnit);
        gerenciador2 = fabricaDeGerenciador.createEntityManager();
    }

    public static EntityManager getGerenciador () {
        if (gerenciador == null) {
            new ConexaoBD();
        }

        return gerenciador;
    }

    public static EntityManager getGerenciador (String persistenceUnit) {
        if (gerenciador2 == null) {
            new ConexaoBD(persistenceUnit);
        }

        return gerenciador2;
    }
}
