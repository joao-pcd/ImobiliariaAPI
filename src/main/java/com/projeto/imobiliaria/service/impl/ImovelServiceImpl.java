package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Endereco;
import com.projeto.imobiliaria.domain.model.Imovel;
import com.projeto.imobiliaria.domain.repository.EnderecoRepository;
import com.projeto.imobiliaria.domain.repository.ImovelRepository;
import com.projeto.imobiliaria.service.ImovelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ImovelServiceImpl implements ImovelService {

    private final ImovelRepository imovelRepository;

    private EnderecoRepository enderecoRepository;

    private ViaCepServiceImpl viaCepServiceImpl;

    @Transactional(readOnly = true)
    @Override
    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Imovel findById(Long id) {
        return imovelRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Imovel create(Imovel imovel) {
        return salvaImovelComEndereco(imovel);
    }


    @Override
    public Imovel update(Long id, Imovel imovel) {
        Imovel imovelbd = this.findById(id);
        if (!imovelbd.getId().equals(imovel.getId())){
            throw new IllegalArgumentException("ID deve ser igual o da entidade");
        }

        return salvaImovelComEndereco(imovel);
    }

    @Override
    public void delete(Long id) {
        imovelRepository.deleteById(id);
    }

    private Imovel salvaImovelComEndereco(Imovel imovel) {
        String cep = imovel.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
            Endereco novoEndereco = viaCepServiceImpl.consultaEndereco(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        imovel.setEndereco(endereco);

        return imovelRepository.save(imovel);
    }
}
