package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Student;
import softuni.repositories.StudentRepository;
import softuni.services.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService<Student,Long>{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findOne(id);
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public List<Object[]> getAllStudentsAndCalculateCoursePrices() {
        return this.studentRepository.findAllAndCalculateCourses();
    }
}
