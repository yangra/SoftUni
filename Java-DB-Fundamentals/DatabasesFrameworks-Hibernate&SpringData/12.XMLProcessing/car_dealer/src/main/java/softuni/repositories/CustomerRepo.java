package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Customer;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    List<Customer> findAllByOrderByBirthDateAscYoungDriverAsc();

//    @Query("SELECT c.name, s.size, SUM(p.price) AS spent_money FROM Customer AS c " +
//            "INNER JOIN c.sales AS s " +
//            "INNER JOIN s.car AS cars " +
//            "INNER JOIN cars.parts AS p " +
//            "GROUP BY c.name, s.size " +
//            "HAVING s.size > 0 " +
//            "ORDER BY spent_money DESC, s.size DESC ")
    @Query("SELECT c FROM Customer AS c WHERE c.sales.size>0")
    List<Customer> findTotalSalesByCustomer();
}
