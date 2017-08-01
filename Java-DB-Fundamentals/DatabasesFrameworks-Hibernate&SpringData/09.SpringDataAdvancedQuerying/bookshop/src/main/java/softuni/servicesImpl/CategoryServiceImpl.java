package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Category;
import softuni.repositories.CategoryRepository;
import softuni.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService<Category,Long> {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategoriesWithBooksMoreThan(long numberOfBooks) {
        return this.categoryRepository.findByBooksGreaterThan(numberOfBooks);
    }
}
