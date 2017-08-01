package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Picture;
import softuni.repositories.PictureRepository;
import softuni.services.PictureService;

import java.util.List;

@Service
@Transactional
public class PictureServiceImpl implements PictureService<Picture, Integer>{
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture findById(Integer id) {
        return this.pictureRepository.findOne(id);
    }

    @Override
    public List<Picture> findAll() {
        return this.pictureRepository.findAll();
    }

    @Override
    public void save(Picture picture) {
        this.pictureRepository.save(picture);
    }
}
