package softuni.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.Photographer;
import softuni.entities.Workshop;
import softuni.repositories.PhotographerRepository;
import softuni.repositories.WorkshopRepository;
import softuni.services.api.WorkshopService;
import softuni.utils.DataValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {
    private final WorkshopRepository workshopRepository;
    private final PhotographerRepository photographerRepository;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository, PhotographerRepository photographerRepository) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void addWorkshop(Workshop workshop) {
        if (DataValidator.validate(workshop)) {
            Photographer photographer = this.photographerRepository
                    .findByFirstNameAndLastName(workshop.getTrainer().getFirstName(), workshop.getTrainer().getLastName());
            workshop.setTrainer(photographer);

            Set<Photographer> participants = new HashSet<>();
            if (workshop.getParticipants() != null) {
                for (Photographer participantDto : workshop.getParticipants()) {
                    Photographer participant = this.photographerRepository
                            .findByFirstNameAndLastName(participantDto.getFirstName(), participantDto.getLastName());
                    participants.add(participant);
                }
            }

            workshop.setParticipants(participants);

            this.workshopRepository.saveAndFlush(workshop);
            System.out.printf("Successfully imported %s", workshop.getName());
        } else {
            System.out.println("Error.Invalid data provided.");
        }

    }

    @Override
    public List<Workshop> getAllOrdered() {
        return this.workshopRepository.findAllByOrderByLocation();
    }
}
