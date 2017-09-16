package softuni.services.api;

import softuni.dto.Export.EmployeeExportJsonDto;
import softuni.dto.Import.EmployeeImportXmlDto;

import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
public interface EmployeeService {
    void saveDto(EmployeeImportXmlDto employeeDto);

    List<EmployeeExportJsonDto> getAllProductive();
}
