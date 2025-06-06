import facade.PedidoFacade;
import model.Produto;
import strategy.PagamentoCartao;
import strategy.PagamentoPix;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PedidoFacade facade = new PedidoFacade();

        long clienteId = 1;

        // 1. Criar um novo pedido para o cliente com ID=1
        var pedido1 = facade.criarPedidoParaCliente(clienteId);

        // 2. Adicionar produtos ao pedido
        facade.adicionarProdutoAoPedido(pedido1, new Produto("Camisa", 79.90));
        facade.adicionarProdutoAoPedido(pedido1, new Produto("Calça", 129.90));

        // 3. Finalizar pedido 1 com pagamento por Cartão
        facade.finalizarPedidoComPagamento(pedido1.getId(), new PagamentoCartao());

        // 4. Duplicar pedido1
        var pedido2 = facade.duplicarPedido(pedido1.getId());

        // 5. Finalizar pedido2 com pagamento por Pix
        facade.finalizarPedidoComPagamento(pedido2.getId(), new PagamentoPix());
    }
}