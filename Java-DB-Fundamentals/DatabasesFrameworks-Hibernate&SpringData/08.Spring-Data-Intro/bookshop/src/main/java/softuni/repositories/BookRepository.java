package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Author;
import softuni.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.title FROM Book AS b WHERE YEAR(b.releaseDate) > :year")
    List<String> findAllByTitleAfterYear(@Param("year") Integer year);

    @Query("SELECT b FROM Book AS b WHERE b.author.firstName = :firstName AND b.author.lastName = :lastName")
    List<Book> findAllByAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName);


}

