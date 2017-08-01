package softuni.services;


import java.util.List;

public interface CategoryService<Category, Long> extends ServiceInterface<Category,Long> {
    List<Category> getCategoriesWithBooksMoreThan(long numberOfBooks);
}
