package com.example.emazon.application.handler;

import com.example.emazon.application.command.CreateCategoryCommand;
import com.example.emazon.application.service.CategoryService;
import com.example.emazon.domain.model.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateCategoryHandler {

    private final CategoryService categoryService;

    public CategoryEntity handle(CreateCategoryCommand command) {
        return categoryService.createCategory(command.getName(), command.getDescription());
    }
}
