package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Course;
import softuni.repositories.CourseRepository;
import softuni.services.CourseService;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService<Course,Long> {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public void save(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public List<Course> findAllOrderedByDates() {
        return this.courseRepository.findAllByOrderByStartDateAscEndDateDesc();
    }

    @Override
    public List<Object[]> getAllCoursesWithResourcesMoreThan(Long numberOfResources) {
        return this.courseRepository.findAllCoursesWithResoursesMoreThan(numberOfResources);
    }

    @Override
    public List<Object[]> getAllActiveOnDate(Date date) {
        return this.courseRepository.findAllActiveOnDate(date);
    }
}
