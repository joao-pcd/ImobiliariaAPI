package com.projeto.imobiliaria.controller;

import com.projeto.imobiliaria.domain.model.Cliente;
import com.projeto.imobiliaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Cliente> findAll() {
        var clientes = clienteService.findAll();
        return ResponseEntity.ok((Cliente) clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        var clienteCriado= clienteService.findById(id);
        return ResponseEntity.ok(clienteCriado);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        var clienteCriado = clienteService.create(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody Cliente cliente) {
        var clienteCriado = clienteService.update(id, cliente);
        return  ResponseEntity.ok(clienteCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
