package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.EmployeeCard;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, Long> {

    EmployeeCard findByNumber(String card);

    @Query("SELECT c FROM EmployeeCard AS c " +
            "LEFT JOIN c.employee AS e WHERE e IS NULL " +
            "ORDER BY c.id ASC")
    List<EmployeeCard> findAllUnused();
}
