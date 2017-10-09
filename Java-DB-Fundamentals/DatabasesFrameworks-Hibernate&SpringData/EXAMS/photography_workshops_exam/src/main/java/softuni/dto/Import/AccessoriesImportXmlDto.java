package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesImportXmlDto {
    @XmlElement(name = "accessory")
    private List<AccessoryImportXmlDto> accessoryImportXmlDtos;

    public AccessoriesImportXmlDto() {
    }

    public List<AccessoryImportXmlDto> getAccessoryImportXmlDtos() {
        return accessoryImportXmlDtos;
    }

    public void setAccessoryImportXmlDtos(List<AccessoryImportXmlDto> accessoryImportXmlDtos) {
        this.accessoryImportXmlDtos = accessoryImportXmlDtos;
    }
}
