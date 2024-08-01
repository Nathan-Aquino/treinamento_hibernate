import dao.ClienteDao;
import dao.IGenericDao;
import model.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteCliente2 {
    private IGenericDao<Cliente> dao = new ClienteDao("treinamento_hibernate2");
    private Integer idCliente;

    @Before
    public void criacaoCliente () {
        Cliente cliente = new Cliente();

        cliente.setNome("Teste");
        cliente.setIdade(33);
        cliente.setEmail("teste@teste.com");

        Cliente clienteCadastrado = dao.cadastrar(cliente);

        Assert.assertNotNull(clienteCadastrado.getId());

        this.idCliente = clienteCadastrado.getId();
    }

    @Test
    public void encontraCliente () {
        Cliente clienteEncontrado = dao.encontrarPorId(Cliente.class, this.idCliente);

        Assert.assertNotNull(clienteEncontrado);
    }
}
