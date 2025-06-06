package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Cloneable {
    private static long contador = 1;

    private long id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = contador++;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.NOVO;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    @Override
    public Pedido clone() {
        try {
            Pedido copia = (Pedido) super.clone();
            copia.id = contador++;
            // Clona a lista de produtos
            copia.produtos = new ArrayList<>();
            for (Produto p : this.produtos) {
                copia.produtos.add(p.clone());
            }
            // Cliente é mantido como referência (mesmo objeto)
            copia.cliente = this.cliente;
            copia.status = StatusPedido.NOVO;
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Falha ao clonar pedido", e);
        }
    }
}
