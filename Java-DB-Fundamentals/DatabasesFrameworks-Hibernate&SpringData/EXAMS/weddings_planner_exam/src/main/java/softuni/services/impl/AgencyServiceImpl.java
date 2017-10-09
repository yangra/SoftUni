package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.*;
import softuni.entities.*;
import softuni.entities.enums.Size;
import softuni.repositories.AgencyRepository;
import softuni.services.api.AgencyService;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void save(Agency agency) {
        this.agencyRepository.saveAndFlush(agency);
    }

    @Override
    public List<AgencyExportJsonDto> getAllOrdered() {
        List<Agency> agencies = this.agencyRepository.findAllByOrderByEmployeesCountDescNameAsc();
        List<AgencyExportJsonDto> agencyExportDtos  = new ArrayList<>();
        for (Agency agency : agencies) {
            AgencyExportJsonDto agencyExportDto = ModelParser.getInstance().map(agency, AgencyExportJsonDto.class);
            agencyExportDtos.add(agencyExportDto);
        }
        return agencyExportDtos;
    }

    @Override
    public TownsExportXmlDto getAgenciesByTowns() {

        List<Agency> agencies = this.agencyRepository.findAllWithAtLeastTwoWeddings();
        List<String> towns = this.agencyRepository.findAllTowns();
        Map<String, List<AgencyExportXmlDto>> agenciesByTowns = new HashMap<>();
        for (String town : towns) {
            List<AgencyExportXmlDto> agenciesByTown = new ArrayList<>();
            for (Agency agency : agencies) {
                if(agency.getTown().equals(town)){
                    AgencyExportXmlDto agencyExportDto = ModelParser.getInstance().map(agency,AgencyExportXmlDto.class);
                    int count = 0;
                    BigDecimal profit = BigDecimal.valueOf(0);
                    for (Wedding wedding : agency.getWeddings()) {
                        BigDecimal cash = BigDecimal.valueOf(0);
                        Integer giftsCounter = 0;
                        for (Invitation invitation : wedding.getInvitations()) {
                            if(invitation.getPresent()!=null&&invitation.getPresent().type().equals("cash")){
                                Cash money = (Cash)invitation.getPresent();
                                cash = cash.add(money.getCashAmount());
                            }
                            if(invitation.getPresent()!=null&&invitation.getPresent().type().equals("gift")){
                                Gift gift = (Gift)invitation.getPresent();
                                if(gift.getSize().equals(Size.Large)||
                                        gift.getSize().equals(Size.Medium)||
                                        gift.getSize().equals(Size.Small)){
                                    giftsCounter++;
                                }
                            }
                        }
                        List<WeddingExportXmlDto> weddings = agencyExportDto.getWeddings();
                        weddings.get(count).setCash(cash);
                        weddings.get(count).setPresents(giftsCounter);
                        profit = profit.add(cash.multiply(BigDecimal.valueOf(0.2)));
                        count++;
                    }
                    agencyExportDto.setProfit(profit);
                    agenciesByTown.add(agencyExportDto);

                }
            }
            if(!agenciesByTown.isEmpty()) {
                agenciesByTowns.put(town, agenciesByTown);
            }
        }
        TownsExportXmlDto townsExportDto = new TownsExportXmlDto();
        List<TownExportXmlDto> townExportDtos = new ArrayList<>();
        for (String town : agenciesByTowns.keySet()) {
            TownExportXmlDto townExportDto = new TownExportXmlDto();
            List<AgencyExportXmlDto> agenciesByTown = agenciesByTowns.get(town);
            townExportDto.setAgencies(agenciesByTown);
            townExportDto.setName(town);
            townExportDtos.add(townExportDto);
        }
        townsExportDto.setTownExportXmlDtos(townExportDtos);
        return townsExportDto;
    }


}
