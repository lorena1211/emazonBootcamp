package com.example.emazon.domain.port.in;

import com.example.emazon.domain.model.CategoryEntity;

public interface CreateCategoryUseCase {
    CategoryEntity createCategory(String name, String description);
}
