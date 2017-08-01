package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Author;
import softuni.repositories.AuthorRepository;
import softuni.services.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService<Author, Long> {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findOne(id);
    }

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthorsFirstNameEndingWith(String suffix) {
        return this.authorRepository.findByFirstNameEndingWith(suffix);
    }
}
