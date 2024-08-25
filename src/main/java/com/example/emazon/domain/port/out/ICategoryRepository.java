package com.example.emazon.domain.port.out;

import com.example.emazon.domain.model.CategoryEntity;

import java.util.Optional;

public interface ICategoryRepository {
    CategoryEntity save(CategoryEntity categoryEntity);
    Optional<CategoryEntity> findByName(String name);
}
