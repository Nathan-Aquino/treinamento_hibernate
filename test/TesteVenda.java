import dao.*;
import model.Cliente;
import model.Produto;
import model.Venda;
import model.VendaProduto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TesteVenda {
    private IGenericDao<Venda> dao = new VendaDao();
    private Integer idVenda;

    @Before
    public void criacaoVenda () {
        IGenericDao<Cliente> clienteDao = new ClienteDao();
        IGenericDao<Produto> produtoDao = new ProdutoDao();
        IGenericDao<VendaProduto> vendaProdutoDao = new VendaProdutoDao();

        Cliente cliente = clienteDao.encontrarTodos(Cliente.class).getFirst();
        Produto produto = produtoDao.encontrarTodos(Produto.class).getFirst();

        Venda venda = new Venda();
        venda.setCliente(cliente);

        Venda vendaCadastrada = dao.cadastrar(venda);

        cliente.setCompra(vendaCadastrada);
        cliente = clienteDao.atualizar(cliente);

        VendaProduto vendaProduto = new VendaProduto();
        vendaProduto.setVenda(vendaCadastrada);
        vendaProduto.setProduto(produto);
        vendaProduto.setQuantidade(2);

        produto.setQuantidade(produto.getQuantidade() - 2);
        produto = produtoDao.atualizar(produto);

        VendaProduto vendaProdutoCadastrado = vendaProdutoDao.cadastrar(vendaProduto);

        List<VendaProduto> vendaProdutoList = new ArrayList<>();
        vendaProdutoList.add(vendaProdutoCadastrado);

        vendaCadastrada.setProdutos(vendaProdutoList);
        vendaCadastrada = dao.atualizar(vendaCadastrada);

        Assert.assertNotNull(vendaCadastrada.getId());
        Assert.assertNotNull(vendaCadastrada.getProdutos());
        Assert.assertNotNull(vendaProdutoCadastrado.getId());
        Assert.assertNotNull(cliente.getCompra());
        Assert.assertEquals((Integer)3, produto.getQuantidade());

        this.idVenda = vendaCadastrada.getId();
    }

    @Test
    public void encontraVenda () {
        Venda venda = dao.encontrarPorId(Venda.class, this.idVenda);

        Assert.assertNotNull(venda);
    }
}
