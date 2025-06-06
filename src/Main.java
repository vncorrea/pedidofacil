import facade.PedidoFacade;
import model.Produto;
import strategy.PagamentoCartao;
import strategy.PagamentoPix;

public class Main {
    public static void main(String[] args) {
        PedidoFacade facade = new PedidoFacade();

        long clienteId = 1;

        var pedido1 = facade.criarPedidoParaCliente(clienteId);

        facade.adicionarProdutoAoPedido(pedido1, new Produto("Camisa", 79.90));
        facade.adicionarProdutoAoPedido(pedido1, new Produto("Calça", 129.90));

        facade.finalizarPedidoComPagamento(pedido1.getId(), new PagamentoCartao());

        var pedido2 = facade.duplicarPedido(pedido1.getId());

        facade.finalizarPedidoComPagamento(pedido2.getId(), new PagamentoPix());
    }
}
