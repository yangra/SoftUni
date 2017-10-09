package softuni.services.api;

import softuni.dto.Export.BranchesExportXmlDto;
import softuni.dto.Import.BranchImportJsonDto;

/**
 * Created by Yana on 8/13/2017.
 */
public interface BranchService {
    void saveDto(BranchImportJsonDto branchImportDto);

    BranchesExportXmlDto getTopBranches();
}
