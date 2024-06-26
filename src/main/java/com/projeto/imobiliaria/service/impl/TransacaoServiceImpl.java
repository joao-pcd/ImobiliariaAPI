package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Imovel;
import com.projeto.imobiliaria.domain.model.Reserva;
import com.projeto.imobiliaria.domain.model.Transacao;
import com.projeto.imobiliaria.domain.repository.*;
import com.projeto.imobiliaria.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository transacaoRepository;

    ReservaRepository reservaRepository;

    ImovelRepository imovelRepository;

    ClienteRepository clienteRepository;

    CorretorRespository corretorRespository;

    @Override
    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao findById(Long id) {
        return transacaoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Transacao create(Transacao transacao) {
        return verificaArgsAttReservaESalvaTransacao(transacao);
    }

    @Override
    public Transacao update(Long id, Transacao transacao) {
        Transacao transacaobd = this.findById(id);
        if (!transacaobd.getId().equals(transacao.getId())){
            throw new IllegalArgumentException("ID deve ser igual o da entidade");
        }
        return verificaArgsAttReservaESalvaTransacao(transacao);
    }

    @Override
    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }

    private Transacao verificaArgsAttReservaESalvaTransacao(Transacao transacao) {
        Imovel imovel = transacao.getImovel();

        if(transacao.getData() == null){
            throw new IllegalArgumentException("A data da reserva não pode ser nulo");
        }

        if (imovelRepository.findById(transacao.getImovel().getId()).isEmpty()){
            throw new IllegalArgumentException("ID do imóvel não foi cadastrado no banco de dados");
        }

        if (clienteRepository.findById(transacao.getComprador().getId()).isEmpty()){
            throw new IllegalArgumentException("ID do cliente não foi cadastrado no banco de dados");
        }

        if (corretorRespository.findById(transacao.getCorretor().getId()).isEmpty()){
            throw new IllegalArgumentException("ID do corretor não foi cadastrado no banco de dados");
        }

        if (transacao.getValor().equals(transacao.getImovel().getPreco())) {
            Reserva reserva = reservaRepository.findByImovelId(imovel);
            if (reserva != null){
                reserva.setStatus("Aprovado");
                reservaRepository.save(reserva);
            }
        }
        return transacaoRepository.save(transacao);
    }
}
