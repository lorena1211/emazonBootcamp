package com.example.emazon.application.handler;

import com.example.emazon.application.command.CreateCategoryCommand;
import com.example.emazon.application.service.CategoryService;
import com.example.emazon.domain.model.CategoryEntity;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateCategoryHandlerTest {

    @Test
    void shouldCreateCategorySuccessfully() {

        CategoryService categoryService = mock(CategoryService.class);
        CreateCategoryHandler handler = new CreateCategoryHandler(categoryService);
        CreateCategoryCommand command = new CreateCategoryCommand("Electronics", "A lot of things");
        when(categoryService.createCategory(command.getName(), command.getDescription()))
                .thenReturn(new CategoryEntity(1L, "Electronics", "A lot of things"));

        CategoryEntity result = handler.handle(command);

        //Assert
        assertNotNull(result);
        assertEquals("Electronics", result.getName());
        assertEquals("A lot of things", result.getDescription());
    }

    @Test
    public void throwExceptionTest(){

        CategoryService categoryService = mock(CategoryService.class);
        CreateCategoryHandler handler = new CreateCategoryHandler(categoryService);
        CreateCategoryCommand command = new CreateCategoryCommand("Electronics", "A lot of things");
        when(categoryService.createCategory(command.getName(), command.getDescription()))
                .thenThrow(new IllegalArgumentException("Invalid category name"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            handler.handle(command);
        });

        assertEquals("Invalid category name", exception.getMessage());
    }

}
