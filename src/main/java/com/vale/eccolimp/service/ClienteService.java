package com.vale.eccolimp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vale.eccolimp.repository.ClienteRepository;
import com.vale.eccolimp.model.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Obter cliente por ID
    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Criar novo cliente
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Atualizar cliente existente
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    return clienteRepository.save(cliente);
                })
                .orElseGet(() -> {
                    clienteAtualizado.setId(id);
                    return clienteRepository.save(clienteAtualizado);
                });
    }

    // Deletar cliente
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
