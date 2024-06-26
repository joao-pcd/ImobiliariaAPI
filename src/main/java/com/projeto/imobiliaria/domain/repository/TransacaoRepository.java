package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
