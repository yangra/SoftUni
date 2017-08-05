package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT DISTINCT u FROM User AS u INNER JOIN u.soldProducts AS p WHERE p.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName " )
    List<User> findBySoldProducts();

    @Query("SELECT u FROM User AS u INNER JOIN u.soldProducts AS sp " +
            "WHERE sp.buyer IS NOT NULL GROUP BY u " +
            "ORDER BY COUNT(sp.id) DESC " )
    List<User> findBySoldProductsCount();
}
