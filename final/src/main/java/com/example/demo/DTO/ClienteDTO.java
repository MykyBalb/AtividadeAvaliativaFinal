package com.example.demo.DTO;

import com.example.demo.Entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String contatos;

    public Cliente toCliente() {
        return new Cliente(this.id, this.nome, this.endereco, this.contatos);
    }

    public static ClienteDTO fromCliente(Cliente c) {
        return new ClienteDTO(c.getIdCliente(), c.getNome(), c.getEndereco(), c.getContatos());
    }
}
