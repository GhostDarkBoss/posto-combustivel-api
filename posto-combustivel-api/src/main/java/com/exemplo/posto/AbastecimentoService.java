package com.exemplo.posto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository repository;

    public AbastecimentoService(AbastecimentoRepository repository) {
        this.repository = repository;
    }

    public List<Abastecimento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Abastecimento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Abastecimento salvar(Abastecimento abastecimento) {
        return repository.save(abastecimento);
    }

    public Abastecimento atualizar(Long id, Abastecimento abastecimento) {
        abastecimento.setId(id);
        return repository.save(abastecimento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
