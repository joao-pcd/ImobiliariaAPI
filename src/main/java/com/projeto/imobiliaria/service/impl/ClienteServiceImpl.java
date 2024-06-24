package com.projeto.imobiliaria.service.impl;

import com.projeto.imobiliaria.domain.model.Cliente;
import com.projeto.imobiliaria.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements com.projeto.imobiliaria.service.ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente create(Cliente clienteParaCriar) {
        if (clienteParaCriar.getNome().isBlank()){
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo.");
        }

        if (clienteRepository.existsById(clienteParaCriar.getId())) {
            throw new IllegalArgumentException("Já existe um usuário cadastrado com esse ID.");
        }
        return clienteRepository.save(clienteParaCriar);
    }

    @Override
    public Cliente update(Long id, Cliente clienteParaAtualizar) {
        Cliente clientedb = this.findById(id);
        if (!clientedb.getId().equals(clienteParaAtualizar.getId())){
            throw new IllegalArgumentException("ID deve ser igual o da entidade");
        }

        clientedb.setNome(clienteParaAtualizar.getNome());

        return this.clienteRepository.save(clientedb);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);

    }

}
