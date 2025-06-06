package service;

import model.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    private ClienteRepository repo = new ClienteRepository();

    public Cliente salvar(Cliente cliente) {
        return repo.salvar(cliente);
    }

    public Cliente buscarPorId(long id) {
        return repo.buscarPorId(id);
    }
}
