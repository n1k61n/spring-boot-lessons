package az.edu.itbrains.fruitables.services.impls;

import az.edu.itbrains.fruitables.dtos.category.CategoryCreateDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.fruitables.models.Category;
import az.edu.itbrains.fruitables.repositories.CategoryRepository;
import az.edu.itbrains.fruitables.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDto getCategoryInfo() {
        return null;
    }

    @Override
    public CategoryCreateDto createCategory(CategoryCreateDto categoryCreateDto) {
        try {
            Category category = modelMapper.map(categoryCreateDto, Category.class);
            categoryRepository.save(category);
            return categoryCreateDto;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public CategoryUpdateDto getUpdatedCategory(Long id) {
        return null;
    }

    @Override
    public CategoryUpdateDto updateCategory(Long id, CategoryUpdateDto categoryUpdateDto) {
        return null;
    }
}
