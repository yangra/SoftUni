package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Course;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findAllByOrderByStartDateAscEndDateDesc();

    @Query("SELECT c.name, COUNT(r.name) AS res_count FROM Course AS c INNER JOIN c.resources AS r " +
            "GROUP BY c.name HAVING COUNT(r.name) > :numberOfResources ORDER BY res_count DESC, c.startDate DESC" )
    List<Object[]> findAllCoursesWithResoursesMoreThan(@Param("numberOfResources") Long numberOfResources);

    @Query("SELECT c.name, c.startDate, c.endDate, DATEDIFF(c.endDate, c.startDate), COUNT(s.name) AS student_count " +
            "FROM Course AS c INNER JOIN c.students AS s " +
            "GROUP BY c.name, c.startDate, c.endDate, DATEDIFF(c.endDate, c.startDate) " +
            "HAVING c.startDate < :date AND c.endDate > :date " +
            "ORDER BY student_count DESC, DATEDIFF(c.endDate, c.startDate) DESC ")
    List<Object[]> findAllActiveOnDate(@Param("date") Date date);
}
