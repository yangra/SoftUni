package softuni.services.api;


import softuni.dto.Import.PhotographerImportJsonDto;
import softuni.entities.Photographer;

import java.util.List;

public interface PhotographerService {
    void save(Photographer photographer);

    List<Photographer> getAllOrdered();

    List<Photographer> getLandscapePhotographers();

    List<Photographer> getAllSameCamera();
}
