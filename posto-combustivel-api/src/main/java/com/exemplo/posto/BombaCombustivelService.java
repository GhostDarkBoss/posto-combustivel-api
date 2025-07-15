package com.exemplo.posto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BombaCombustivelService {

    private final BombaCombustivelRepository repository;

    public BombaCombustivelService(BombaCombustivelRepository repository) {
        this.repository = repository;
    }

    public List<BombaCombustivel> listarTodos() {
        return repository.findAll();
    }

    public Optional<BombaCombustivel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public BombaCombustivel salvar(BombaCombustivel bomba) {
        return repository.save(bomba);
    }

    public BombaCombustivel atualizar(Long id, BombaCombustivel bomba) {
        bomba.setId(id);
        return repository.save(bomba);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
