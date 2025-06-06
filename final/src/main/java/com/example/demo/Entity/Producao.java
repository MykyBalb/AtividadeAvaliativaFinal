package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducao;
    private String tipoAco;
    private String especificacao;
    private int quantidade;
}
