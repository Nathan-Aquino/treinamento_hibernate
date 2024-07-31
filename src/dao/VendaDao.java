package dao;

import model.Venda;

import java.util.List;

public class VendaDao extends GenericDao<Venda> implements IGenericDao<Venda>{
    public VendaDao () {
        super();
    }

    @Override
    public Venda cadastrar(Venda objeto) {
        return super.cadastrar(objeto);
    }

    @Override
    public void deletar(Class<Venda> entidadeClasse, Integer id) {
        super.deletar(entidadeClasse, id);
    }

    @Override
    public Venda atualizar(Venda objeto) {
        return super.atualizar(objeto);
    }

    @Override
    public Venda encontrarPorId(Class<Venda> entidadeClasse, Integer id) {
        return super.encontrarPorId(entidadeClasse, id);
    }

    @Override
    public List<Venda> encontrarTodos(Class<Venda> entidadeClasse) {
        return super.encontrarTodos(entidadeClasse);
    }
}
