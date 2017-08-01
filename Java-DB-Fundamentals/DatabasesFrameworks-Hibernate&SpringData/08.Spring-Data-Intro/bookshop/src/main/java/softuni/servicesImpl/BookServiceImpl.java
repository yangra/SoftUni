package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Book;
import softuni.repositories.BookRepository;
import softuni.services.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService<Book,Long> {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<String> getAllTitlesAfterYear(Integer year) {
        return this.bookRepository.findAllByTitleAfterYear(year);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        String[] authorName = author.split("\\s+");

        return this.bookRepository.findAllByAuthor(authorName[0], authorName[1]);
    }

}
