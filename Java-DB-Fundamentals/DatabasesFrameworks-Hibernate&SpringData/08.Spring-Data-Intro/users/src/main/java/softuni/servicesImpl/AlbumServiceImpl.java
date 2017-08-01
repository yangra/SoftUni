package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Album;
import softuni.repositories.AlbumRepository;
import softuni.services.AlbumService;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService<Album, Integer> {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album findById(Integer id) {
        return this.albumRepository.findOne(id);
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }

    @Override
    public void save(Album album) {
        this.albumRepository.save(album);
    }
}
