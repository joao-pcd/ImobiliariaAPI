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
    @PrimaryKeyJoinColumn(name = "imovel_id")
    @Cascade(CascadeType.ALL)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn(nullable = false, name = "comprador_id")
    @Cascade(CascadeType.ALL)
    private Cliente comprador;

    @JoinColumn(nullable = false, name = "corretor_id")
    @ManyToOne
    private Corretor corretor;
}
