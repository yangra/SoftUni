package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name="photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographersSameCameraXmlExportDto {
    @XmlElement(name="photographer")
    List<PhotographerSameCameraXmlExportDto> photographerSameCameraXmlExportDtos;

    public List<PhotographerSameCameraXmlExportDto> getPhotographerSameCameraXmlExportDtos() {
        return photographerSameCameraXmlExportDtos;
    }

    public void setPhotographerSameCameraXmlExportDtos(List<PhotographerSameCameraXmlExportDto> photographerSameCameraXmlExportDtos) {
        this.photographerSameCameraXmlExportDtos = photographerSameCameraXmlExportDtos;
    }
}
