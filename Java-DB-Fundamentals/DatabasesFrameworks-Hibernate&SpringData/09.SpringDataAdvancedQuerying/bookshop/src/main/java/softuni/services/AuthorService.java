package softuni.services;


import java.util.List;

public interface AuthorService<Author, Long> extends ServiceInterface<Author, Long> {
    List<Author> getAuthorsFirstNameEndingWith(String suffix);
}
