package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_cliente")
@Getter
@Setter
public class Cliente extends Pessoa{
}
