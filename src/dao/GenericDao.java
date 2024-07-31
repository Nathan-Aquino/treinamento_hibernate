package dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDao<T> implements IGenericDao <T> {

    private EntityManager gerenciador;

    GenericDao () {
        this.gerenciador = ConexaoBD.getGerenciador();
    }

    @Override
    public T cadastrar(T objeto) {
        gerenciador.getTransaction().begin();
        gerenciador.persist(objeto);
        gerenciador.getTransaction().commit();

        return objeto;
    }

    @Override
    public void deletar(Class<T> entidadeClasse,Integer id) {
        T objeto = gerenciador.find(entidadeClasse, id);

        if (objeto != null) {
            gerenciador.getTransaction().begin();
            gerenciador.remove(objeto);
            gerenciador.getTransaction().commit();
        }
    }

    @Override
    public T atualizar (T objeto) {
        gerenciador.getTransaction().begin();
        T objetoAlterado = gerenciador.merge(objeto);
        gerenciador.getTransaction().commit();

        return objetoAlterado;
    }

    @Override
    public T encontrarPorId(Class<T> entidadeClasse, Integer id) {
        T objeto = gerenciador.find(entidadeClasse, id);

        if (objeto != null) {
            return objeto;
        }

        return null;
    }

    @Override
    public List<T> encontrarTodos(Class<T> entidadeClasse) {
        String queryString = "SELECT e from " + entidadeClasse.getSimpleName() + " e";
        List<T> objetos = gerenciador.createQuery(queryString, entidadeClasse).getResultList();
        return objetos;
    }
}
