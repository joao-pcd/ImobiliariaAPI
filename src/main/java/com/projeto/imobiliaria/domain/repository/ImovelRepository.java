package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
