package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Product;

/**
 * Created by Yana on 8/13/2017.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
