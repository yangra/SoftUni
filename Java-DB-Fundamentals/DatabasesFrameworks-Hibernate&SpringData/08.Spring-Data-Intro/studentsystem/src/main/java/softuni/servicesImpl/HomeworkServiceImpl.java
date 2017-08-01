package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Homework;
import softuni.entities.Student;
import softuni.repositories.HomeworkRepository;
import softuni.services.HomeworkService;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService<Homework,Long> {
    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public List<Homework> findAll() {
        return this.homeworkRepository.findAll();
    }

    @Override
    public Homework findById(Long id) {
        return this.homeworkRepository.findOne(id);
    }

    @Override
    public void save(Homework homework) {
        this.homeworkRepository.save(homework);
    }

    @Override
    public List<Homework> findByStudent(Student student) {
        return this.homeworkRepository.findByStudent(student);
    }
}
