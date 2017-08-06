package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Part;

@Repository
public interface PartRepo extends JpaRepository<Part,Long> {
}
