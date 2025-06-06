package repository;

import model.Cliente;
import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    private Map<Long, Cliente> mapaClientes = new HashMap<>();
    private long nextId = 1;

    public ClienteRepository() {

        Cliente exemplo = new Cliente(nextId, "Cliente Exemplo");
        mapaClientes.put(nextId, exemplo);
        nextId++;
    }

    public Cliente salvar(Cliente cliente) {
        cliente = new Cliente(nextId, cliente.getNome());
        mapaClientes.put(nextId, cliente);
        nextId++;
        return cliente;
    }

    public Cliente buscarPorId(long id) {
        return mapaClientes.get(id);
    }
}
