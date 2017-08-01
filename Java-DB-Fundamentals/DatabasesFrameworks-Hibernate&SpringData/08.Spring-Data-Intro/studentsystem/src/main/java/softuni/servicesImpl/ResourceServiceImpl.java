package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Course;
import softuni.entities.Resource;
import softuni.repositories.ResourceRepository;
import softuni.services.ResourceService;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService<Resource, Long> {
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> findAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public Resource findById(Long id) {
        return this.resourceRepository.findOne(id);
    }

    @Override
    public void save(Resource resource) {
        this.resourceRepository.save(resource);
    }

    @Override
    public List<Resource> findByCourse(Course course) {
        return this.resourceRepository.findAllByCourse(course);
    }
}
