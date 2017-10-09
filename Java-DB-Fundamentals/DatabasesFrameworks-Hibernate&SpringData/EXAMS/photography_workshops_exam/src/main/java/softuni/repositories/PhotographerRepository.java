package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Photographer;

import java.util.List;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer,Long> {
    Photographer findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT f FROM Photographer AS f ORDER BY f.firstName ASC , f.lastName DESC ")
    List<Photographer> findOrdered();

    @Query("SELECT f FROM Photographer AS f WHERE f.primaryCamera.make = f.secondaryCamera.make")
    List<Photographer> findAllSameCamera();
}
