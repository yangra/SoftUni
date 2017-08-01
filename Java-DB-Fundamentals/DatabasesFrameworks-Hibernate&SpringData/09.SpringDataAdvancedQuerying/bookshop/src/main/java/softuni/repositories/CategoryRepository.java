package softuni.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category AS c INNER JOIN c.books AS b GROUP BY c HAVING COUNT(b) > :numberOfBooks ORDER BY COUNT(b) DESC")
    List<Category> findByBooksGreaterThan(@Param("numberOfBooks") long numberOfBooks);
}

