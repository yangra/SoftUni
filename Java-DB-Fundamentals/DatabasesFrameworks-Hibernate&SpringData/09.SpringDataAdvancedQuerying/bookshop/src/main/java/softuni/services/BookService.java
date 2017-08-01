package softuni.services;


import softuni.entities.AgeRestriction;
import softuni.entities.Book;
import softuni.entities.Category;
import softuni.entities.EditionType;
import softuni.repositories.ReducedBook;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface BookService<Book,Long> extends ServiceInterface<Book,Long> {

    List<Book> getAllBooksWithAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getAllBooksByEditionTypeAndNumberOfCopies(EditionType editionType, int numberOfCopies);

    List<Book> getAllBooksWithPriceLessThanAndOver(BigDecimal low, BigDecimal high);

    List<Book> getAllBooksNotReleasedIn(Integer year);

    List<Book> getBooksByCategories(String[] names, long length);

    List<Book> getAllBooksReleasedBefore(Date date);

    List<Book> getBooksWithTitlesContaining(String string);

    List<Book> getBooksAuthorsLastNameEndsWith(String string);

    Integer getAllBooksWithTitleLongerThan(Integer symbolCount);

    List<Object[]> getAuthorsTotalCopies();

    List<Object[]> getProfitByCategory();

    List<Object[]> getMostRecentByCategory(String category, int limit);

    ReducedBook getBookByTitle(String title);
}
