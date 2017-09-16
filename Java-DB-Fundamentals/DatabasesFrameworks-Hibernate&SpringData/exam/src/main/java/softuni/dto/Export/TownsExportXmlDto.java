package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsExportXmlDto {
    @XmlElement(name = "town")
    private List<TownExportXmlDto> townExportXmlDtos;

    public List<TownExportXmlDto> getTownExportXmlDtos() {
        return townExportXmlDtos;
    }

    public void setTownExportXmlDtos(List<TownExportXmlDto> townExportXmlDtos) {
        this.townExportXmlDtos = townExportXmlDtos;
    }
}
