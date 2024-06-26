package com.projeto.imobiliaria.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private BigDecimal valor;

    @OneToOne
    @Column(nullable = false)
    @Cascade(CascadeType.ALL)
    private Imovel imovel;

    @ManyToOne
    @Column(nullable = false)
    @Cascade(CascadeType.ALL)
    private Cliente comprador;

    @Column(nullable = false)
    @ManyToOne
    private Corretor corretor;
}
