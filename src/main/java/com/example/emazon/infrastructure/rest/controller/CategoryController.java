package com.example.emazon.infrastructure.rest.controller;

import com.example.emazon.application.command.CreateCategoryCommand;
import com.example.emazon.application.handler.CreateCategoryHandler;
import com.example.emazon.domain.model.CategoryEntity;
import com.example.emazon.infrastructure.rest.dto.CategoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryHandler createCategoryHandler;
    //private final ListCategoriesHandler listCategoriesHandler;

    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CreateCategoryCommand command = new CreateCategoryCommand(categoryDto.getName(), categoryDto.getDescription());
        CategoryEntity newCategory = createCategoryHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    /*@GetMapping
    public Page<CategoryEntity> listCategories(@RequestParam(defaultValue = "name") String sortBy,
                                               @RequestParam(defaultValue = "asc") String sortDirection,
                                               Pageable pageable) {
        return listCategoriesHandler.handle(pageable);
    }*/

}
