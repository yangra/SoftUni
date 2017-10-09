package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name="venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesImportXmlDto {
    @XmlElement(name="venue")
    private List<VenueImportXmlDto> venueImportXmlDtos;

    public List<VenueImportXmlDto> getVenueImportXmlDtos() {
        return venueImportXmlDtos;
    }

    public void setVenueImportXmlDtos(List<VenueImportXmlDto> venueImportXmlDtos) {
        this.venueImportXmlDtos = venueImportXmlDtos;
    }
}
