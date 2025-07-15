package com.exemplo.posto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/combustiveis")
public class CombustivelController {

    private final CombustivelService service;

    public CombustivelController(CombustivelService service) {
        this.service = service;
    }

    @GetMapping
    public List<Combustivel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combustivel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Combustivel criar(@RequestBody Combustivel combustivel) {
        return service.salvar(combustivel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combustivel> atualizar(@PathVariable Long id, @RequestBody Combustivel combustivel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Combustivel atualizado = service.atualizar(id, combustivel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
