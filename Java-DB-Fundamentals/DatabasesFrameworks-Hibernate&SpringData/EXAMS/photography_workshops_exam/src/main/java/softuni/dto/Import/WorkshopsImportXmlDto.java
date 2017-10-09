package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yana on 8/9/2017.
 */
@XmlRootElement(name="workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsImportXmlDto {
    @XmlElement(name = "workshop")
    private List<WorkshopImportXmlDto> workshopImportXmlDtos;

    public WorkshopsImportXmlDto() {
    }

    public List<WorkshopImportXmlDto> getWorkshopImportXmlDtos() {
        return workshopImportXmlDtos;
    }

    public void setWorkshopImportXmlDtos(List<WorkshopImportXmlDto> workshopImportXmlDtos) {
        this.workshopImportXmlDtos = workshopImportXmlDtos;
    }
}
