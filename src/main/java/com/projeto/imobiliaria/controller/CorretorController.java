package com.projeto.imobiliaria.controller;

import com.projeto.imobiliaria.domain.model.Corretor;
import com.projeto.imobiliaria.service.CorretorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/corretor")
@RequiredArgsConstructor
public class CorretorController {

    private final CorretorService corretorService;

    @GetMapping
    public ResponseEntity<Corretor> findAll() {
        var corretores = corretorService.findAll();
        return ResponseEntity.ok((Corretor) corretores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corretor> findById(@PathVariable Long id){
        var corretorCriado = corretorService.findById(id);
        return ResponseEntity.ok(corretorCriado);
    }

    @PostMapping
    public ResponseEntity<Corretor> create(@RequestBody Corretor corretor){
        var corretorCriado = corretorService.create(corretor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(corretorCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(corretorCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Corretor> update(@PathVariable Long id, @RequestBody Corretor corretor) {
        var corretorCriado = corretorService.update(id, corretor);
        return  ResponseEntity.ok(corretorCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        corretorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
