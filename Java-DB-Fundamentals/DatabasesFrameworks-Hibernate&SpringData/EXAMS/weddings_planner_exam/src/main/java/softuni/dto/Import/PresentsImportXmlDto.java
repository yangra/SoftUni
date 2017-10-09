package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentsImportXmlDto {
    @XmlElement(name = "present")
    private List<PresentImportXmlDto> presentImportXmlDtos;

    public List<PresentImportXmlDto> getPresentImportXmlDtos() {
        return presentImportXmlDtos;
    }

    public void setPresentImportXmlDtos(List<PresentImportXmlDto> presentImportXmlDtos) {
        this.presentImportXmlDtos = presentImportXmlDtos;
    }
}
