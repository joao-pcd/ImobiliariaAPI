package com.projeto.imobiliaria.controller;

import com.projeto.imobiliaria.domain.model.Reserva;
import com.projeto.imobiliaria.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public ResponseEntity<Reserva> findAll() {
        var reservas = reservaService.findAll();
        return ResponseEntity.ok((Reserva) reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id){
        var reservaCriada = reservaService.findById(id);
        return ResponseEntity.ok(reservaCriada);
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva){
        var reservaCriada = reservaService.create(reserva);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reservaCriada.getId())
                .toUri();
        return ResponseEntity.created(location).body(reservaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
        var reservaCriada = reservaService.update(id, reserva);
        return  ResponseEntity.ok(reservaCriada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
