package com.example.demo.DTO;

import com.example.demo.Entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {
    private Long id;
    private String materiaPrima;
    private int produtoAcabado;

    public Client toEstoque() {
        return new Client(this.id, this.materiaPrima, this.produtoAcabado);
    }

    public static EstoqueDTO fromEstoque(Client e) {
        return new EstoqueDTO(e.getIdEstoque(), e.getMateriaPrima(), e.getProdutoAcabado());
    }
}
