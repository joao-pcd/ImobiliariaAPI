package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private BigDecimal valor;

    @OneToOne
    @Cascade(CascadeType.ALL)
    private Imovel imovel;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Cliente comprador;

    @ManyToOne
    private Corretor corretor;
}
