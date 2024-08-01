
import dao.IGenericDao;
import dao.ProdutoDao;
import model.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteProduto2 {
    private IGenericDao<Produto> dao = new ProdutoDao("treinamento_hibernate2");
    private Integer idProduto;

    @Before
    public void criacaoProduto () {
        Produto produto = new Produto();

        produto.setNome("TesteProduto");
        produto.setPreco(10);
        produto.setQuantidade(5);

        Produto produtoCadastrado = dao.cadastrar(produto);

        Assert.assertNotNull(produtoCadastrado.getId());

        this.idProduto = produtoCadastrado.getId();
    }

    @Test
    public void encontraProduto () {
        Produto produtoEncontrado = dao.encontrarPorId(Produto.class, this.idProduto);

        Assert.assertNotNull(produtoEncontrado);
    }
}
