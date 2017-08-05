package softuni.services.api;


import softuni.dto.JsonImport.PartImportJsonDto;
import softuni.dto.JsonImport.PartDto;

import java.util.List;

public interface PartService {
    void savePartDto(PartImportJsonDto partImportJsonDto);

    List<PartDto> findAllPartDto();
}
