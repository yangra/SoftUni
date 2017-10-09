package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.VenueExportXmlDto;
import softuni.dto.Export.VenuesExportXmlDto;
import softuni.dto.Import.VenueImportXmlDto;
import softuni.entities.Venue;
import softuni.repositories.VenueRepository;
import softuni.services.api.VenueService;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    @Autowired
    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public void saveDto(VenueImportXmlDto venueImportDto) {
        Venue venue = ModelParser.getInstance().map(venueImportDto, Venue.class);
        this.venueRepository.saveAndFlush(venue);
    }

    @Override
    public List<Venue> getAll() {
        return this.venueRepository.findAll();
    }

    @Override
    public VenuesExportXmlDto getVenuesIn(String town, Integer count) {
        List<Venue> venues = this.venueRepository.findByTown(town, count);
        VenuesExportXmlDto venuesExportDto = new VenuesExportXmlDto();
        List<VenueExportXmlDto> venueExportDtos = new ArrayList<>();
        for (Venue venue : venues) {
            VenueExportXmlDto venueExportDto = ModelParser.getInstance().map(venue,VenueExportXmlDto.class);
            venueExportDtos.add(venueExportDto);
        }
        venuesExportDto.setVenueExportXmlDtos(venueExportDtos);
        return venuesExportDto;
    }
}
