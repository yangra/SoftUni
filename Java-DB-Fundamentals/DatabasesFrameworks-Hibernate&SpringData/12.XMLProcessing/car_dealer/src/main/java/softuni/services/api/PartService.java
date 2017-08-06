package softuni.services.api;


import softuni.dto.binding.Import.PartImportDto;
import softuni.dto.binding.Import.PartDto;

import java.util.List;

public interface PartService {
    void savePartDto(PartImportDto partImportDto);

    List<PartDto> findAllPartDto();
}
