package strategy;

import model.Pedido;

public interface PagamentoStrategy {
    void pagar(Pedido pedido);
}
