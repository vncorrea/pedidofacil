package strategy;

import model.Pedido;

public class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Gerando boleto para Pedido #" + pedido.getId());
        // lógica de boleto (simulada)…
    }
}
