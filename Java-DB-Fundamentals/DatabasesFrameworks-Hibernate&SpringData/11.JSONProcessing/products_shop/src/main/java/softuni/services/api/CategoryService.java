package softuni.services.api;


import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.Add.CategoryAddDto;
import softuni.dto.view.Query3.CategoryViewDto;

import java.util.List;

public interface CategoryService {
    void save(CategoryAddDto categoryAddDto);

    List<CategoryDto> findAll();

    List<CategoryViewDto> getAllCategoriesByProductCount();
}
