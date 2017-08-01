package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) <> :year")
    List<Book> findAllNotReleasedIn(@Param("year") Integer year);

    @Query("SELECT b FROM Book AS b " +
            "WHERE (SELECT COUNT(c) FROM b.categories AS c WHERE c.name IN :names ) = :len ")
    List<Book> findAllByCategories(@Param("names") String[] names, @Param("len") long length);

    List<Book>  findAllByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContaining(String string);

    @Query("SELECT b FROM Book AS b INNER JOIN b.author AS a WHERE a.lastName LIKE CONCAT(:prefix, '%')")
    List<Book> findAllByAuthorsLastNameEndingWith(@Param("prefix") String string);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title)> :count")
    Integer findAllByTitleLongerThan(@Param("count") Integer symbolCount);

    @Query("SELECT a.firstName, a.lastName,SUM(b.copies) AS total_copies FROM Book AS b INNER JOIN b.author AS a " +
            "GROUP BY a.firstName, a.lastName ORDER BY total_copies DESC ")
    List<Object[]> findAuthorsTotalCopies();

    @Query("SELECT c.name, SUM(b.price * b.copies) AS profit FROM Book AS b INNER JOIN b.categories AS c " +
            "GROUP BY c.name ORDER BY profit DESC, c.name ASC ")
    List<Object[]> findProfitByCategory();

    @Query(value = "SELECT b.title, b.release_date FROM books AS b " +
            "INNER JOIN books_categories AS bc ON b.id = bc.book_id " +
            "INNER JOIN categories AS c ON bc.category_id = c.id " +
            "WHERE c.name = :name " +
            "ORDER BY b.release_date DESC, b.title ASC " +
            "LIMIT :limit", nativeQuery = true)
    List<Object[]> findMostRecentByCategory(@Param("name") String category, @Param("limit") int limit);

    ReducedBook findByTitle(String title);
}

