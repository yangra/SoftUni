package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Town;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Repository
public interface TownRepository extends JpaRepository<Town,Long>{
    Town findByName(String town);

    @Query("SELECT t, SUM(p.clients) AS clients FROM Town AS t " +
            "INNER JOIN t.branches AS b " +
            "INNER JOIN b.products AS p " +
            "GROUP BY t " +
            "ORDER BY  clients DESC ")
    List<Object[]> findAllTowns();
}
