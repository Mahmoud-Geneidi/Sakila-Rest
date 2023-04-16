package com.gov.iti.sakila.mappers;

import com.gov.iti.sakila.presentation.dto.CategoryDto;
import com.gov.iti.sakila.persistence.entities.Category;

import javax.annotation.processing.Generated;


@Generated(value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-04-07T19:50:39+0200",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)")
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setName( category.getName() );
        categoryDto.setLastUpdate( category.getLastUpdate() );

        return categoryDto;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto category) {
        if ( category == null ) {
            return null;
        }

        Category category1 = new Category();

        category1.setCategoryId( category.getCategoryId() );
        category1.setName( category.getName() );
        category1.setLastUpdate( category.getLastUpdate() );

        return category1;
    }
}
