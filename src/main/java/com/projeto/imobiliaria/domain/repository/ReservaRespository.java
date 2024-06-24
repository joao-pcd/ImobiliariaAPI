package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRespository extends JpaRepository<Reserva, Long> {
}
