package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Venue;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    @Query("SELECT v FROM Venue AS v " +
            "WHERE v.town = :town AND v.weddings.size > :count " +
            "ORDER BY v.capacity")
    List<Venue> findByTown(@Param("town") String town, @Param("count") Integer count);
}
