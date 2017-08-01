package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("SELECT DISTINCT a FROM Book AS b INNER JOIN b.author AS a WHERE YEAR(b.releaseDate) < :year")
    List<Author> findAllAuthorsWithBookReleaseDateBefore(@Param("year") Integer year);

    @Query("SELECT a.firstName, a.lastName, COUNT(b.title) AS book_count FROM Book AS b RIGHT OUTER JOIN b.author AS a " +
            "GROUP BY a.firstName, a.lastName ORDER BY book_count DESC")
    List<Object[]> findAllByTheNumberOfBooks();
}
