package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Corretor;
import com.projeto.imobiliaria.domain.repository.CorretorRespository;
import com.projeto.imobiliaria.service.CorretorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class CorretorServiceImpl implements CorretorService {

    private final CorretorRespository corretorRespository;

    @Transactional(readOnly = true)
    @Override
    public List<Corretor> findAll() {
        return corretorRespository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Corretor findById(Long id) {
        return corretorRespository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Corretor create(Corretor corretorParaCriar) {
        if(corretorParaCriar.getNome().isBlank()){
            throw new IllegalArgumentException("O nome do corretor não pode ser nulo");
        }

        if (corretorRespository.existsById(corretorParaCriar.getId())) {
            throw new IllegalArgumentException("Já existe um corretor cadastrado com esse ID");
        }

        return corretorRespository.save(corretorParaCriar);
    }

    @Override
    public Corretor update(Long id, Corretor corretorParaAtualizar) {
        Corretor corretordb = this.findById(id);
        if (!corretordb.getId().equals(corretorParaAtualizar.getId())){
            throw new IllegalArgumentException("ID deve ser igual o da entidade");
        }
        corretordb.setNome(corretorParaAtualizar.getNome());

        return this.corretorRespository.save(corretordb);
    }

    @Override
    public void delete(Long id) {
        corretorRespository.deleteById(id);
    }
}
