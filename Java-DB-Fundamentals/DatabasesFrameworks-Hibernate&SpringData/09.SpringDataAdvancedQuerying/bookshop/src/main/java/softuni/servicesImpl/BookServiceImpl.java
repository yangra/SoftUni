package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.AgeRestriction;
import softuni.entities.Book;
import softuni.entities.Category;
import softuni.entities.EditionType;
import softuni.repositories.BookRepository;
import softuni.repositories.ReducedBook;
import softuni.services.BookService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    public List<Book> getAllBooksWithAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> getAllBooksByEditionTypeAndNumberOfCopies(EditionType editionType, int numberOfCopies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, numberOfCopies);
    }

    @Override
    public List<Book> getAllBooksWithPriceLessThanAndOver(BigDecimal low, BigDecimal high) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(low,high);
    }

    @Override
    public List<Book> getAllBooksNotReleasedIn(Integer year) {
        return this.bookRepository.findAllNotReleasedIn(year);
    }

    @Override
    public List<Book> getBooksByCategories(String[] names, long length) {
        return this.bookRepository.findAllByCategories(names, length);
    }

    @Override
    public List<Book> getAllBooksReleasedBefore(Date date) {
        return this.bookRepository.findAllByReleaseDateBefore(date);
    }

    @Override
    public List<Book> getBooksWithTitlesContaining(String string) {
        return this.bookRepository.findAllByTitleContaining(string);
    }

    @Override
    public List<Book> getBooksAuthorsLastNameEndsWith(String string) {
        return this.bookRepository.findAllByAuthorsLastNameEndingWith(string);
    }

    @Override
    public Integer getAllBooksWithTitleLongerThan(Integer symbolCount) {
        return this.bookRepository.findAllByTitleLongerThan(symbolCount);
    }

    @Override
    public List<Object[]> getAuthorsTotalCopies() {
        return this.bookRepository.findAuthorsTotalCopies();
    }

    @Override
    public List<Object[]> getProfitByCategory() {
        return this.bookRepository.findProfitByCategory();
    }

    @Override
    public List<Object[]> getMostRecentByCategory(String category, int limit) {
        return this.bookRepository.findMostRecentByCategory(category, limit);
    }

    @Override
    public ReducedBook getBookByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }

}
