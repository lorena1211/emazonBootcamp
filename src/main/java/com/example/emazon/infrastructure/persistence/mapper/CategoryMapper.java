package com.example.emazon.infrastructure.persistence.mapper;

import com.example.emazon.domain.model.CategoryEntity;
import com.example.emazon.infrastructure.persistence.jpa.JpaCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryEntity toDomainCategory(JpaCategory jpaCategory) {
        return new CategoryEntity(jpaCategory.getId(), jpaCategory.getName(), jpaCategory.getDescription());
    }

    public JpaCategory toJpaCategory(CategoryEntity categoryEntity) {
        return new JpaCategory(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
    }
}
