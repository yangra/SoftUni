package softuni.services.api;


import softuni.dto.Import.LensImportJsonDto;
import softuni.entities.Lens;

import java.util.List;

public interface LensService {
    void saveLensDto(LensImportJsonDto lensImportJsonDto);

    List<Lens> findAll();
}
