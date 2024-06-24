package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Override
    boolean existsById(Long clienteId);
}
