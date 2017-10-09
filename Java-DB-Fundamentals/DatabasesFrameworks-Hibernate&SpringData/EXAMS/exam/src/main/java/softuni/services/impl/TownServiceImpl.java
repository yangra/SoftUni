package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.TownExportXmlDto;
import softuni.dto.Export.TownsExportXmlDto;
import softuni.dto.Import.TownImportJsonDto;
import softuni.entities.Town;
import softuni.repositories.TownRepository;
import softuni.services.api.TownService;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Service
@Transactional
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void saveDto(TownImportJsonDto townImportDto) {
        if (DataValidator.validate(townImportDto)) {
            Town town = ModelParser.getInstance().map(townImportDto, Town.class);
            this.townRepository.saveAndFlush(town);
            System.out.printf("Successfully imported Town %s\n", town.getName());
        } else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public TownsExportXmlDto getAllTowns() {
        List<Object[]> towns = this.townRepository.findAllTowns();
        TownsExportXmlDto townsDto = new TownsExportXmlDto();
        List<TownExportXmlDto> townDtos = new ArrayList<>();
        for (Object[] object : towns) {
            TownExportXmlDto townDto = ModelParser.getInstance().map((Town) object[0], TownExportXmlDto.class);
            townDto.setClients((Long) object[1]);
            townDtos.add(townDto);
        }
        townsDto.setTownExportXmlDtos(townDtos);
        return townsDto;
    }
}
