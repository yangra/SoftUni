package softuni.services.api;

import softuni.dto.Export.EmployeeCardExportJsonDto;
import softuni.dto.Import.EmployeeCardImportJsonDto;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
public interface EmployeeCardService {
    void saveDto(EmployeeCardImportJsonDto employeeCardDto);

    List<EmployeeCardExportJsonDto> getAllUnused();
}
