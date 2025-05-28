package com.example.demo.Service;

import com.example.demo.DTO.ClienteDTO;
import com.example.demo.DTO.EstoqueDTO;
import com.example.demo.Entity.Client;
import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository rpCliente;

    public List<Cliente> findAll() {return rpCliente.findAll();}

    public ClienteDTO create(ClienteDTO c) {
        Cliente cliente = c.toCliente();
        cliente = rpCliente.save(cliente);
        return c.fromCliente(cliente);
    }

    public Optional<EstoqueDTO> update(Long id, EstoqueDTO clienteDTO) {
        Optional<Cliente> estoqueOp = rpCliente.findById(id);
        if (estoqueOp.isPresent()) {
            Cliente client = estoqueOp.get();
            client.setMateriaPrima(clienteDTO.getMateriaPrima());
            client.setProdutoAcabado(clienteDTO.getProdutoAcabado());
            Cliente updated = rpCliente.save(client);
            return Optional.of(clienteDTO);
        }
        return Optional.empty();
    }
}