package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c.name, COUNT(p.id), AVG(p.price), SUM(p.price) FROM Category AS c " +
            "INNER JOIN c.products AS p GROUP BY c.name ORDER BY COUNT(p.id) DESC")
    List<Object[]> findAllByNumberOfProducts();
}
