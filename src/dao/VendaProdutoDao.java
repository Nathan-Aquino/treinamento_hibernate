package dao;

import model.VendaProduto;

import java.util.List;

public class VendaProdutoDao extends GenericDao<VendaProduto> implements IGenericDao<VendaProduto> {
    public VendaProdutoDao () {
        super();
    }

    @Override
    public VendaProduto cadastrar(VendaProduto objeto) {
        return super.cadastrar(objeto);
    }

    @Override
    public void deletar(Class<VendaProduto> entidadeClasse, Integer id) {
        super.deletar(entidadeClasse, id);
    }

    @Override
    public VendaProduto encontrarPorId(Class<VendaProduto> entidadeClasse, Integer id) {
        return super.encontrarPorId(entidadeClasse, id);
    }

    @Override
    public VendaProduto atualizar(VendaProduto objeto) {
        return super.atualizar(objeto);
    }

    @Override
    public List<VendaProduto> encontrarTodos(Class<VendaProduto> entidadeClasse) {
        return super.encontrarTodos(entidadeClasse);
    }
}
