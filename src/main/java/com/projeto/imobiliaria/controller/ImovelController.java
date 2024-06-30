package com.projeto.imobiliaria.controller;

import com.projeto.imobiliaria.domain.model.Imovel;
import com.projeto.imobiliaria.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/imovel")
@RequiredArgsConstructor
public class ImovelController {

    private final ImovelService imovelService;

    @GetMapping
    public ResponseEntity<Imovel> findAll() {
        var imoveis = imovelService.findAll();
        return ResponseEntity.ok((Imovel) imoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable Long id){
        var imovelCriado = imovelService.findById(id);
        return ResponseEntity.ok(imovelCriado);
    }

    @PostMapping
    public ResponseEntity<Imovel> create(@RequestBody Imovel imovel){
        var imovelCriado = imovelService.create(imovel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(imovelCriado.getId())
                .toUri();
        return ResponseEntity.created(location).body(imovelCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> update(@PathVariable Long id, @RequestBody Imovel imovel) {
        var imovelCriado = imovelService.update(id, imovel);
        return  ResponseEntity.ok(imovelCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        imovelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
