package service;

import model.Pedido;
import model.StatusPedido;
import strategy.PagamentoStrategy;

public class PagamentoService {
    public void processarPagamento(Pedido pedido, PagamentoStrategy strategy) {
        strategy.pagar(pedido);
        pedido.setStatus(StatusPedido.PAGO);
    }
}
