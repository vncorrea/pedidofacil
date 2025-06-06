package strategy;


import model.Pedido;

public class PagamentoCartao implements PagamentoStrategy {
    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Processando pagamento por Cartão para Pedido #" + pedido.getId());
        // lógica de cartão (simulada)…
    }
}
