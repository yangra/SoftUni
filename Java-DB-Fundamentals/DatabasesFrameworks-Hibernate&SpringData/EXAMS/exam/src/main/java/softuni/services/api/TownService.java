package softuni.services.api;

import softuni.dto.Export.TownsExportXmlDto;
import softuni.dto.Import.TownImportJsonDto;

/**
 * Created by Yana on 8/13/2017.
 */
public interface TownService {
    void saveDto(TownImportJsonDto townImportDto);

    TownsExportXmlDto getAllTowns();
}
