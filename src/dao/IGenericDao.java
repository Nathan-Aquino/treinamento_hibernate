package dao;

import java.util.List;

public interface IGenericDao<T> {
    public T cadastrar (T objeto);
    public void deletar (Class<T> classeEntidade, Integer id);
    public T atualizar (T objeto);
    public T encontrarPorId (Class<T> entidadeClasse, Integer id);
    public List<T> encontrarTodos (Class<T> entidadeClasse);
}
