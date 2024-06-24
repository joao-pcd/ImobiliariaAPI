package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
