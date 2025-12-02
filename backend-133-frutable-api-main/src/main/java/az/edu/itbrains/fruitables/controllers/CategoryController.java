package az.edu.itbrains.fruitables.controllers;


import az.edu.itbrains.fruitables.dtos.category.CategoryCreateDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryDto;
import az.edu.itbrains.fruitables.dtos.category.CategoryUpdateDto;
import az.edu.itbrains.fruitables.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {



    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<CategoryDto> getCategory(){

        CategoryDto category = categoryService.getCategoryInfo();
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CategoryCreateDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto){

        CategoryCreateDto categoryCreate = categoryService.createCategory(categoryCreateDto);
        return new ResponseEntity<>(categoryCreate, HttpStatus.CREATED);

    }

    @GetMapping("/update/{id}")
    public ResponseEntity<CategoryUpdateDto> getCategoryUpdate(@PathVariable Long id){

        CategoryUpdateDto categoryUpdateDto = categoryService.getUpdatedCategory(id);
        return new ResponseEntity<>(categoryUpdateDto, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryUpdateDto> getCategoryUpdate(@PathVariable Long id, @RequestBody CategoryUpdateDto categoryUpdateDto){
        CategoryUpdateDto category = categoryService.updateCategory(id, categoryUpdateDto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
