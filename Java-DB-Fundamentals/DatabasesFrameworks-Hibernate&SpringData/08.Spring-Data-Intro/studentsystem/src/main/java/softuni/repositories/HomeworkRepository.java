package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Homework;
import softuni.entities.Student;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Long> {
    @Query("SELECT h FROM Homework AS h WHERE h.student = :student")
    List<Homework> findByStudent(@Param("student") Student student);
}
