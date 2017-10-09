package softuni.services.api;


import softuni.entities.Workshop;

import java.util.List;

public interface WorkshopService {
    void addWorkshop(Workshop workshop);

    List<Workshop> getAllOrdered();
}
