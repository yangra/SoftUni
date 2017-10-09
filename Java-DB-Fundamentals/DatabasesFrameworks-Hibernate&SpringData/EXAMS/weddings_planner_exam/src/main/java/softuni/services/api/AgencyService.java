package softuni.services.api;


import softuni.dto.Export.AgencyExportJsonDto;
import softuni.dto.Export.TownsExportXmlDto;
import softuni.entities.Agency;

import java.util.List;

public interface AgencyService {
    void save(Agency agency);

    List<AgencyExportJsonDto> getAllOrdered();

    TownsExportXmlDto getAgenciesByTowns();
}
