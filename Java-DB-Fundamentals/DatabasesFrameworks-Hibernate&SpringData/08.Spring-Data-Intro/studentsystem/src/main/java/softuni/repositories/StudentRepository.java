package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s.name, COUNT(c.name) AS number, SUM(c.price) AS total, AVG(c.price) AS average " +
            "FROM Student AS s INNER JOIN s.courses AS c " +
            "GROUP BY s.name " +
            "ORDER BY total DESC, number DESC, s.name ")
    List<Object[]> findAllAndCalculateCourses();

}
