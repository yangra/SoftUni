package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByFirstNameAndMiddleNameInitialAndLastName(String firstName, String middleNameInitial, String lastName);
}
