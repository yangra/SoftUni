package softuni.services;


import softuni.entities.Course;

import java.util.Date;
import java.util.List;

public interface CourseService<Course,Long> extends ServiceInterface<Course,Long> {

    List<softuni.entities.Course> findAllOrderedByDates();

    List<Object[]> getAllCoursesWithResourcesMoreThan(Long numberOfResourses);

    List<Object[]> getAllActiveOnDate(Date date);
}
