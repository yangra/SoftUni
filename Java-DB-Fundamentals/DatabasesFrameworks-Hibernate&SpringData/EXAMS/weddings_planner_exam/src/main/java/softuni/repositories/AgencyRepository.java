package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Agency;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Long> {
    List<Agency> findByName(String name);

    List<Agency> findAllByOrderByEmployeesCountDescNameAsc();

    @Query("SELECT a FROM Agency AS a WHERE a.weddings.size >= 2")
    List<Agency> findAllWithAtLeastTwoWeddings();

    @Query("SELECT a.town FROM Agency AS a WHERE LENGTH(a.town)>=6")
    List<String> findAllTowns();
}
