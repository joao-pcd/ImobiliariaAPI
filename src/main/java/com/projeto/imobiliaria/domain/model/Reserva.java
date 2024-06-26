package com.projeto.imobiliaria.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;

@Entity(name = "tb_reserva")
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @JsonIgnore
    private String status = "Pendente";

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Imovel imovelId;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Cliente clienteId;

}
