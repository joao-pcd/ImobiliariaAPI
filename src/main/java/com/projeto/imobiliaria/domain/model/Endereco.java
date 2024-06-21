package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_endereco")
@Getter
@Setter
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
}
