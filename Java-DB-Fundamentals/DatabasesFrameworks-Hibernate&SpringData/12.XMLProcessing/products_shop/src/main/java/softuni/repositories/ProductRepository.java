package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Product;
import softuni.entities.User;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal lowLimit, BigDecimal highLimit);
    @Query("SELECT DISTINCT p FROM User AS u INNER JOIN u.soldProducts AS p WHERE p.buyer IS NOT NULL " +
            "ORDER BY u.lastName, u.firstName" )
    List<Product> findBySoldProducts();

    @Query("SELECT p FROM Product AS p WHERE p.buyer IS NOT NULL AND p.seller.id = :userId")
    List<Product> findSoldProductsByUserId(@Param("userId") Long userId);
}
