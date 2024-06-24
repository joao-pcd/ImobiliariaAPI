package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Pessoa {

    @Column(nullable = false, length = 50)
    private String nome;
}
