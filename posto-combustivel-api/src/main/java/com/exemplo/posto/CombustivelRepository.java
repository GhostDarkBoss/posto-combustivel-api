package com.exemplo.posto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
    // Métodos CRUD já inclusos via JpaRepository
}
