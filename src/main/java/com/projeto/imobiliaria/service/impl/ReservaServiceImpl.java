package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Reserva;
import com.projeto.imobiliaria.domain.repository.ClienteRepository;
import com.projeto.imobiliaria.domain.repository.ImovelRepository;
import com.projeto.imobiliaria.domain.repository.ReservaRepository;
import com.projeto.imobiliaria.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    
    ImovelRepository imovelRepository;
    
    ClienteRepository clienteRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Reserva create(Reserva reserva) {
        return verificaArgsESalvaCliente(reserva);
    }

    @Override
    public Reserva update(Long id, Reserva reserva) {
        Reserva reservabd = this.findById(id);
        if (!reservabd.getId().equals(reserva.getId())){
            throw new IllegalArgumentException("ID deve ser igual o da entidade");
        }
        return verificaArgsESalvaCliente(reserva);
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }

    private Reserva verificaArgsESalvaCliente(Reserva reserva) {
        if(reserva.getData() == null){
            throw new IllegalArgumentException("A data da reserva não pode ser nulo");
        }

        if (imovelRepository.findById(reserva.getImovelId().getId()).isEmpty()){
            throw new IllegalArgumentException("ID do imóvel não foi cadastrado no banco de dados");
        }

        if (clienteRepository.findById(reserva.getClienteId().getId()).isEmpty()){
            throw new IllegalArgumentException("ID do imóvel não foi cadastrado no banco de dados");
        }

        return reservaRepository.save(reserva);
    }
}
