package softuni.dto.view.Query4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsPartsXmlDto {
    @XmlElement(name="car")
    private List<CarPartsXmlDto> carPartsXmlDtos;

    public CarsPartsXmlDto() {
    }

    public List<CarPartsXmlDto> getCarPartsXmlDtos() {
        return carPartsXmlDtos;
    }

    public void setCarPartsXmlDtos(List<CarPartsXmlDto> carPartsXmlDtos) {
        this.carPartsXmlDtos = carPartsXmlDtos;
    }
}
