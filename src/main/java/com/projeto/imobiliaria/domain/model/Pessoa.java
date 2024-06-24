package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.Column;


public abstract class Pessoa {

    @Column(nullable = false, length = 50)
    private String nome;
}
