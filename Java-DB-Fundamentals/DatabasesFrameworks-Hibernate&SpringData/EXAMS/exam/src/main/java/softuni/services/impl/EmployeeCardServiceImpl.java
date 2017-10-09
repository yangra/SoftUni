package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.EmployeeCardExportJsonDto;
import softuni.dto.Import.EmployeeCardImportJsonDto;
import softuni.entities.EmployeeCard;
import softuni.repositories.EmployeeCardRepository;
import softuni.services.api.EmployeeCardService;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService {
    private final EmployeeCardRepository employeeCardRepository;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository) {
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public void saveDto(EmployeeCardImportJsonDto employeeCardDto) {
        List<EmployeeCard> employeeCards = this.employeeCardRepository.findAll();
        EmployeeCard employeeCard = ModelParser.getInstance().map(employeeCardDto, EmployeeCard.class);
        for (EmployeeCard card : employeeCards) {
            if (employeeCard.getNumber().equals(card.getNumber())) {
                System.out.println("Error: Invalid data. Card number not unique. ");
                return;
            }
        }
        this.employeeCardRepository.saveAndFlush(employeeCard);
        System.out.printf("Successfully imported Employee Card %s.\n", employeeCard.getNumber());
    }

    @Override
    public List<EmployeeCardExportJsonDto> getAllUnused() {
        List<EmployeeCard> employeeCards = this.employeeCardRepository.findAllUnused();
        List<EmployeeCardExportJsonDto> employeeCardDtos = new ArrayList<>();
        for (EmployeeCard employeeCard : employeeCards) {
            EmployeeCardExportJsonDto employeeCardDto = ModelParser.getInstance().map(employeeCard, EmployeeCardExportJsonDto.class);
            employeeCardDtos.add(employeeCardDto);
        }
        return employeeCardDtos;
    }
}
