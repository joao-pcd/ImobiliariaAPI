package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "tb_imovel")
@Getter
@Setter
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Endereco endereco;

    @Column(precision = 13, scale = 2)
    private BigDecimal preco;

    private String tipo;
}
