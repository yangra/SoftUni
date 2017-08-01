package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Course;
import softuni.entities.Resource;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long>{
    List<Resource> findAllByCourse(Course course);
}
