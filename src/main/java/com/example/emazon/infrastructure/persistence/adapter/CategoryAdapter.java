package com.example.emazon.infrastructure.persistence.adapter;

import com.example.emazon.domain.model.CategoryEntity;
import com.example.emazon.domain.port.out.ICategoryRepository;
import com.example.emazon.infrastructure.persistence.jpa.JpaCategory;
import com.example.emazon.infrastructure.persistence.jpa.JpaCategoryRepository;
import com.example.emazon.infrastructure.persistence.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryRepository {

    private final JpaCategoryRepository jpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity){
        JpaCategory jpaCategory = categoryMapper.toJpaCategory(categoryEntity);
        JpaCategory savedCategory = jpaRepository.save(jpaCategory);
        return categoryMapper.toDomainCategory(savedCategory);
    }

    @Override
    public Optional<CategoryEntity> findByName(String name) {
        return jpaRepository.findByName(name)
                .map(categoryMapper::toDomainCategory);
    }
}
