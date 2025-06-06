package service;


import model.Pedido;
import repository.PedidoRepository;

public class PedidoService {
    private PedidoRepository repo = new PedidoRepository();

    public void salvar(Pedido pedido) {
        repo.salvar(pedido);
    }

    public Pedido buscarPorId(long id) {
        return repo.buscarPorId(id);
    }

    public void atualizar(Pedido pedido) {
        repo.atualizar(pedido);
    }

    public Pedido duplicarPedido(Pedido original) {
        Pedido copia = original.clone();
        repo.salvar(copia);
        return copia;
    }
}
