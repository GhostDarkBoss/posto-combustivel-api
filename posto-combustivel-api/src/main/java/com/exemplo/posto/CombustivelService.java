package com.exemplo.posto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombustivelService {

    private final CombustivelRepository repository;

    public CombustivelService(CombustivelRepository repository) {
        this.repository = repository;
    }

    public List<Combustivel> listarTodos() {
        return repository.findAll();
    }

    public Optional<Combustivel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Combustivel salvar(Combustivel combustivel) {
        return repository.save(combustivel);
    }

    public Combustivel atualizar(Long id, Combustivel combustivel) {
        combustivel.setId(id);
        return repository.save(combustivel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
