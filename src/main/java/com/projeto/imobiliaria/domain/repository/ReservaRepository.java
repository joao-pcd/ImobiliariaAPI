package com.projeto.imobiliaria.domain.repository;

import com.projeto.imobiliaria.domain.model.Imovel;
import com.projeto.imobiliaria.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findByImovelId(Imovel imovel);
}
