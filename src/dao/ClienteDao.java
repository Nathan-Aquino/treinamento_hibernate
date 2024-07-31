package dao;

import model.Cliente;

import java.util.List;

public class ClienteDao extends GenericDao<Cliente> implements IGenericDao<Cliente>{

    public ClienteDao() {
        super();
    }

    @Override
    public Cliente cadastrar(Cliente objeto) {
        return super.cadastrar(objeto);
    }

    @Override
    public void deletar(Class<Cliente> entidadeClasse, Integer id) {
        super.deletar(entidadeClasse, id);
    }

    @Override
    public Cliente atualizar(Cliente objeto) {
        return super.atualizar(objeto);
    }

    @Override
    public Cliente encontrarPorId(Class<Cliente> entidadeClasse, Integer id) {
        return super.encontrarPorId(entidadeClasse, id);
    }

    @Override
    public List<Cliente> encontrarTodos(Class<Cliente> entidadeClasse) {
        return super.encontrarTodos(entidadeClasse);
    }
}
