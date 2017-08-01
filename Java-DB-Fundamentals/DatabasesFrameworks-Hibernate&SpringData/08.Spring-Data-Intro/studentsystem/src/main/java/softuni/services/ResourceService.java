package softuni.services;


import softuni.entities.Course;
import softuni.entities.Resource;

import java.util.List;

public interface ResourceService<Resource,Long> extends ServiceInterface<Resource,Long>{
    List<Resource> findByCourse(Course course);
}
