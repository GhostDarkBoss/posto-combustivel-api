package com.exemplo.posto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bombas")
public class BombaCombustivelController {

    private final BombaCombustivelService service;

    public BombaCombustivelController(BombaCombustivelService service) {
        this.service = service;
    }

    @GetMapping
    public List<BombaCombustivel> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombaCombustivel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BombaCombustivel criar(@RequestBody BombaCombustivel bomba) {
        return service.salvar(bomba);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BombaCombustivel> atualizar(@PathVariable Long id, @RequestBody BombaCombustivel bomba) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        BombaCombustivel atualizado = service.atualizar(id, bomba);
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
