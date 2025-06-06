package repository;

import model.Pedido;

import java.util.HashMap;
import java.util.Map;

public class PedidoRepository {
    private Map<Long, Pedido> mapaPedidos = new HashMap<>();

    public void salvar(Pedido pedido) {
        mapaPedidos.put(pedido.getId(), pedido);
    }

    public Pedido buscarPorId(long id) {
        return mapaPedidos.get(id);
    }

    public void atualizar(Pedido pedido) {
        mapaPedidos.put(pedido.getId(), pedido);
    }
}
