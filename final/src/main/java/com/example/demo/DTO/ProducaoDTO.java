package com.example.demo.DTO;

import com.example.demo.Entity.Producao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProducaoDTO {
    private Long id;
    private String tipoAco;
    private String especificacao;
    private int quantidade;

    public Producao toProducao() {return new Producao(this.id, this.tipoAco, this.especificacao, this.quantidade);}

    public static ProducaoDTO fromProducao(Producao p) {
        return new ProducaoDTO(p.getIdProducao(), p.getTipoAco(), p.getEspecificacao(), p.getQuantidade());
    }
}
