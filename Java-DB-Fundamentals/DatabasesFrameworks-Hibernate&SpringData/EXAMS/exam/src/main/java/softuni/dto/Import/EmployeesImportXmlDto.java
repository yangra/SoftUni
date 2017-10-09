package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlRootElement(name="employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesImportXmlDto {
    @XmlElement(name = "employee")
    List<EmployeeImportXmlDto> employeeImportXmlDtos;

    public List<EmployeeImportXmlDto> getEmployeeImportXmlDtos() {
        return employeeImportXmlDtos;
    }

    public void setEmployeeImportXmlDtos(List<EmployeeImportXmlDto> employeeImportXmlDtos) {
        this.employeeImportXmlDtos = employeeImportXmlDtos;
    }
}
