package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findByFirstNameEndingWith(String suffix);
}
