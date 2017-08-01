package softuni.services;


import softuni.entities.Homework;
import softuni.entities.Student;

import java.util.List;

public interface HomeworkService<Homework,Long> extends ServiceInterface<Homework,Long> {
    List<Homework> findByStudent(Student s);
}
