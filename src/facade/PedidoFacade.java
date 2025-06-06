package facade;

import model.Cliente;
import model.Pedido;
import model.Produto;
import service.ClienteService;
import service.PagamentoService;
import service.PedidoService;
import strategy.PagamentoStrategy;

public class PedidoFacade {
    private ClienteService clienteService = new ClienteService();
    private PedidoService pedidoService = new PedidoService();
    private PagamentoService pagamentoService = new PagamentoService();

    /**
     * Cria um pedido novo para um cliente já existente (id = 1 criado no repositório).
     */
    public Pedido criarPedidoParaCliente(long clienteId) {
        Cliente cliente = clienteService.buscarPorId(clienteId);
        Pedido pedido = new Pedido(cliente);
        pedidoService.salvar(pedido);
        System.out.println("Pedido #" + pedido.getId() + " criado para Cliente " + cliente.getNome());
        return pedido;
    }

    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto) {
        pedido.adicionarProduto(produto);
        pedidoService.atualizar(pedido);
        System.out.println("Produto '" + produto.getNome() + "' adicionado ao Pedido #" + pedido.getId());
    }

    public Pedido duplicarPedido(long pedidoId) {
        Pedido original = pedidoService.buscarPorId(pedidoId);
        Pedido copia = pedidoService.duplicarPedido(original);
        System.out.println("Pedido #" + pedidoId + " duplicado como Pedido #" + copia.getId());
        return copia;
    }

    public void finalizarPedidoComPagamento(long pedidoId, PagamentoStrategy strategy) {
        Pedido pedido = pedidoService.buscarPorId(pedidoId);
        pagamentoService.processarPagamento(pedido, strategy);
        System.out.println("Pedido #" + pedido.getId() + " marcado como PAGO.");
    }
}
