package softuni.services.api;

import softuni.dto.Export.WeddingExportJsonDto;
import softuni.dto.Import.WeddingImportJsonDto;
import softuni.entities.Wedding;

import java.util.List;

/**
 * Created by Yana on 8/10/2017.
 */
public interface WeddingService {
    void saveDto(WeddingImportJsonDto weddingDto);

    List<Wedding> getAll();

    void save(Wedding wedding);

    List<WeddingExportJsonDto> getWeddingDetails();
}
