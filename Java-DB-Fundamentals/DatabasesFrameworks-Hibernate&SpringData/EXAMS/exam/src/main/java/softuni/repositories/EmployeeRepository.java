package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Employee;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee AS e " +
            "INNER JOIN  e.branch AS b " +
            "INNER JOIN b.products " +
            "ORDER BY CONCAT(e.firstName,' ',e.lastName) ASC, LENGTH(e.position) DESC ")
    List<Employee> findAllProductive();
}
