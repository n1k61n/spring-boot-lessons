package az.edu.itbrains.fruitables.services;

import az.edu.itbrains.fruitables.dtos.category.CategoryCreateDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryUpdateDto;

public interface CategoryService {
    CategoryDto getCategoryInfo();

    CategoryCreateDto createCategory(CategoryCreateDto categoryCreateDto);

    CategoryUpdateDto getUpdatedCategory(Long id);

    CategoryUpdateDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDto);
}
