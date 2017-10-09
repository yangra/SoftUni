package softuni.services.api;

import softuni.dto.Export.VenuesExportXmlDto;
import softuni.dto.Import.VenueImportXmlDto;
import softuni.dto.Import.VenuesImportXmlDto;
import softuni.entities.Venue;

import java.util.List;

/**
 * Created by Yana on 8/10/2017.
 */
public interface VenueService {
    void saveDto(VenueImportXmlDto venueImportDto);

    List<Venue> getAll();

    VenuesExportXmlDto getVenuesIn(String town, Integer count);
}
