package softuni.services;


import java.util.List;

public interface StudentService<Student,Long> extends ServiceInterface<Student,Long> {
    List<Object[]> getAllStudentsAndCalculateCoursePrices();
}
