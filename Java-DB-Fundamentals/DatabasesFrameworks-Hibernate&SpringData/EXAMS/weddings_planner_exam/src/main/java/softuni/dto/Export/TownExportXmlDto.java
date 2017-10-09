package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Yana on 8/11/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TownExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlElementWrapper(name="agencies")
    @XmlElement(name="agency")
    private List<AgencyExportXmlDto> agencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AgencyExportXmlDto> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<AgencyExportXmlDto> agencies) {
        this.agencies = agencies;
    }
}
