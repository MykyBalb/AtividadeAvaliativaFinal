package com.example.demo.DTO;

import com.example.demo.Entity.Estoque;
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
    private int quantidade;

    public Estoque toEstoque() {
        return new Estoque(this.id, this.quantidade);
    }

    public static EstoqueDTO fromEstoque(Estoque e) {
        return new EstoqueDTO(e.getIdEstoque(), e.getQuantidade());
    }
}
