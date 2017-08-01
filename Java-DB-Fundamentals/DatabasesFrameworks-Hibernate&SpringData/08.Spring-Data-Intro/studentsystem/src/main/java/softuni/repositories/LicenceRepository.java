package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.License;

@Repository
public interface LicenceRepository extends JpaRepository<License,Long>{
}
