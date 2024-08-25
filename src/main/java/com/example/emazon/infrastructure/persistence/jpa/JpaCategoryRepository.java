package com.example.emazon.infrastructure.persistence.jpa;

import com.example.emazon.domain.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCategoryRepository extends JpaRepository<JpaCategory, Long> {
    Optional<JpaCategory> findByName(String name);
}
