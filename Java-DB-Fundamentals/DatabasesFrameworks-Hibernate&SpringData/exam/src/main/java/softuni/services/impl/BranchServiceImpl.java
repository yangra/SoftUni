package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.dto.Export.BranchExportXmlDto;
import softuni.dto.Export.BranchesExportXmlDto;
import softuni.dto.Import.BranchImportJsonDto;
import softuni.entities.Branch;
import softuni.entities.Town;
import softuni.repositories.BranchRepository;
import softuni.repositories.TownRepository;
import softuni.services.api.BranchService;
import softuni.utils.DataValidator;
import softuni.utils.ModelParser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@Service
@Transactional
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final TownRepository townRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TownRepository townRepository) {
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
    }

    @Override
    public void saveDto(BranchImportJsonDto branchImportDto) {
        if (DataValidator.validate(branchImportDto)) {
            Branch branch = ModelParser.getInstance().map(branchImportDto, Branch.class);
            Town town = this.townRepository.findByName(branchImportDto.getTown());
            if (town != null) {
                branch.setTown(town);
            } else {
                System.out.println("Error: Invalid data. No such town.");
                return;
            }

            this.branchRepository.saveAndFlush(branch);
            System.out.printf("Successfully imported Branch %s\n", branch.getName());
        } else {
            System.out.println("Error: Invalid data.");
        }
    }

    @Override
    public BranchesExportXmlDto getTopBranches() {
        List<Object[]> branches = this.branchRepository.findTopBranches();
        List<BranchExportXmlDto> branchDtos = new ArrayList<>();
        for (Object[] object : branches) {
            BranchExportXmlDto branchDto = ModelParser.getInstance().map((Branch) object[0], BranchExportXmlDto.class);
            if ((Long) object[1] == null) {
                branchDto.setClients(0L);
            } else {
                branchDto.setClients((Long) object[1]);
            }

            branchDtos.add(branchDto);
        }
        BranchesExportXmlDto branchesDto = new BranchesExportXmlDto();
        branchesDto.setBranchExportXmlDtos(branchDtos);
        return branchesDto;
    }
}
