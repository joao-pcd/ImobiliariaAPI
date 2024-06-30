package com.projeto.imobiliaria.controller;

import com.projeto.imobiliaria.domain.model.Transacao;
import com.projeto.imobiliaria.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<Transacao> findAll() {
        var transacoes = transacaoService.findAll();
        return ResponseEntity.ok((Transacao) transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> findById(@PathVariable Long id){
        var transacaoCriada = transacaoService.findById(id);
        return ResponseEntity.ok(transacaoCriada);
    }

    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao){
        var transacaoCriada = transacaoService.create(transacao);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transacaoCriada.getId())
                .toUri();
        return ResponseEntity.created(location).body(transacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> update(@PathVariable Long id, @RequestBody Transacao transacao) {
        var transacaoCriada = transacaoService.update(id, transacao);
        return  ResponseEntity.ok(transacaoCriada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
