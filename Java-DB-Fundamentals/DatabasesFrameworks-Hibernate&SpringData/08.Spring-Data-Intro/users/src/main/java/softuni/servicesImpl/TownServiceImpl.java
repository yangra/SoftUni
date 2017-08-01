package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Town;
import softuni.repositories.TownRepository;
import softuni.services.TownService;

import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService<Town, Integer> {
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town findById(Integer id) {
        return this.townRepository.findOne(id);
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public void save(Town town) {
        this.townRepository.save(town);
    }
}
