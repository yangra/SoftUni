package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LocationExportXmlDto {
    @XmlAttribute(name = "name")
    private String location;

    @XmlElement(name = "workshop" )
    private List<WorkshopExportXmlDto> workshopExportXmlDtos;
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<WorkshopExportXmlDto> getWorkshopExportXmlDtos() {
        return workshopExportXmlDtos;
    }

    public void setWorkshopExportXmlDtos(List<WorkshopExportXmlDto> workshopExportXmlDtos) {
        this.workshopExportXmlDtos = workshopExportXmlDtos;
    }
}
