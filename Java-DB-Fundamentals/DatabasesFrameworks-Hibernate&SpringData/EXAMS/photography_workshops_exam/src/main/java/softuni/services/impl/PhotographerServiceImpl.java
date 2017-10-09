package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.dto.Import.PhotographerImportJsonDto;
import softuni.entities.Photographer;
import softuni.io.ModelParser;
import softuni.repositories.PhotographerRepository;
import softuni.services.api.PhotographerService;
import softuni.utils.DataValidator;

import java.util.List;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {
    private final PhotographerRepository photographerRepository;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository) {
        this.photographerRepository = photographerRepository;
    }


    @Override
    public void save(Photographer photographer) {
        this.photographerRepository.saveAndFlush(photographer);
    }

    @Override
    public List<Photographer> getAllOrdered() {
        return this.photographerRepository.findOrdered();
    }

    @Override
    public List<Photographer> getLandscapePhotographers() {
        List<Photographer> all = this.photographerRepository.findAll();
        all.removeIf(f->!f.getPrimaryCamera().type().equals("DSLR"));
        all.removeIf(f->f.getLenses().size()<1||f.getLenses().stream().anyMatch(l->l.getFocalLength()>30));
        all.stream().sorted((a,b)->a.getFirstName().compareTo(b.getFirstName()));
        return all;
    }

    @Override
    public List<Photographer> getAllSameCamera() {
        return this.photographerRepository.findAllSameCamera();
    }
}
