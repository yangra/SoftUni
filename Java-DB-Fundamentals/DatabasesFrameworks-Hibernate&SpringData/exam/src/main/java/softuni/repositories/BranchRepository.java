package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Branch;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {
    Branch findByName(String name);

    @Query("SELECT b, SUM(p.clients) AS clients FROM Branch AS b " +
            "LEFT JOIN b.products AS p " +
            "GROUP BY b " +
            "ORDER BY clients DESC ")
    List<Object[]> findTopBranches();
}
