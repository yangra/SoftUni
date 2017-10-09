package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationsExportXmlDto {
    @XmlElement(name="location")
    private List<LocationExportXmlDto> locationExportXmlDtos;

    public List<LocationExportXmlDto> getLocationExportXmlDtos() {
        return locationExportXmlDtos;
    }

    public void setLocationExportXmlDtos(List<LocationExportXmlDto> locationExportXmlDtos) {
        this.locationExportXmlDtos = locationExportXmlDtos;
    }
}
