package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesExportXmlDto {
    @XmlElement(name="venue")
    private List<VenueExportXmlDto> venueExportXmlDtos;

    public List<VenueExportXmlDto> getVenueExportXmlDtos() {
        return venueExportXmlDtos;
    }

    public void setVenueExportXmlDtos(List<VenueExportXmlDto> venueExportXmlDtos) {
        this.venueExportXmlDtos = venueExportXmlDtos;
    }

    @XmlAttribute
    public String getTown(){
        String result = "";
        for (VenueExportXmlDto venueExportXmlDto : venueExportXmlDtos) {
            result = venueExportXmlDto.getTown();
        }
        return result;
    }
}
