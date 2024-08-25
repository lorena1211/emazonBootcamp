package com.example.emazon.application.service;

import com.example.emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.emazon.domain.model.CategoryEntity;
import com.example.emazon.domain.port.out.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ICategoryRepository categoryRepository;

    /*public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(String name, String description) {
        Optional<CategoryEntity> existingCategory = categoryRepository.findByName(name);
        if (existingCategory.isPresent()) {
            throw new CategoryAlreadyExistsException("Category with name "+name+" already exists.");
        }

        CategoryEntity newCategory = new CategoryEntity(null, name, description);
        categoryRepository.save(newCategory);
    }

    public Optional<CategoryEntity> findByName(String name) {
        return categoryRepository.findByName(name);
    }*/
    public CategoryEntity createCategory(String name, String description){
        if (categoryRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("Category name already exists.");

        }
        CategoryEntity categoryEntity = new CategoryEntity(null, name, description);
        return categoryRepository.save(categoryEntity);
    }
}
