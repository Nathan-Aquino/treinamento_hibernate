package dao;

import model.Produto;

import java.util.List;

public class ProdutoDao extends GenericDao<Produto> implements IGenericDao<Produto>{
    public ProdutoDao () {
        super();
    }

    @Override
    public Produto cadastrar(Produto objeto) {
        return super.cadastrar(objeto);
    }

    @Override
    public void deletar(Class<Produto> entidadeClasse, Integer id) {
        super.deletar(entidadeClasse, id);
    }

    @Override
    public Produto atualizar(Produto objeto) {
        return super.atualizar(objeto);
    }

    @Override
    public Produto encontrarPorId(Class<Produto> entidadeClasse, Integer id) {
        return super.encontrarPorId(entidadeClasse, id);
    }

    @Override
    public List<Produto> encontrarTodos(Class<Produto> entidadeClasse) {
        return super.encontrarTodos(entidadeClasse);
    }
}
