package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Accessory;
import softuni.entities.Photographer;
import softuni.repositories.AccessoryRepository;
import softuni.repositories.PhotographerRepository;
import softuni.services.api.AccessoryService;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AccessoryServiceImpl implements AccessoryService{
    private final AccessoryRepository accessoryRepository;
    private final PhotographerRepository photographerRepository;

    @Autowired
    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void addAccessory(Accessory accessory) {
        List<Photographer> photographers = this.photographerRepository.findAll();
        Random random = new Random();
        accessory.setOwner(photographers.get(random.nextInt(photographers.size())));
        this.accessoryRepository.saveAndFlush(accessory);
    }
}
