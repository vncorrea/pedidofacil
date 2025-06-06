package strategy;

import model.Pedido;

public class PagamentoPix implements PagamentoStrategy {
    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Gerando QR Code Pix para Pedido #" + pedido.getId());
        // lógica de Pix (simulada)…
    }
}
