package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.Add.CategoryAddDto;
import softuni.dto.view.Query3.CategoryViewDto;
import softuni.entities.Category;
import softuni.io.ModelParser;
import softuni.repositories.CategoryRepository;
import softuni.services.api.CategoryService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryAddDto categoryAddDto) {
        Category category = ModelParser.getInstance().map(categoryAddDto, Category.class);
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = ModelParser.getInstance().map(category, CategoryDto.class);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public List<CategoryViewDto> getAllCategoriesByProductCount() {
        List<Object[]> categories = this.categoryRepository.findAllByNumberOfProducts();
        List<CategoryViewDto> categoryViewDtos = new ArrayList<>();
        for (Object[] category : categories) {
            CategoryViewDto categoryViewDto = new CategoryViewDto();
            categoryViewDto.setCategory((String) category[0]);
            categoryViewDto.setProductCount((Long) category[1]);
            categoryViewDto.setAveragePrice(BigDecimal.valueOf(Double.parseDouble(category[2].toString())));
            categoryViewDto.setTotalRevenue(BigDecimal.valueOf(Double.parseDouble(category[3].toString())));
            categoryViewDtos.add(categoryViewDto);
        }

        return categoryViewDtos;
    }
}
