package softuni.dto.view.Query2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsToyotaXmlDto {
    @XmlElement(name = "car")
    private List<CarToyotaDto> carToyotaDtos;

    public CarsToyotaXmlDto() {
    }

    public List<CarToyotaDto> getCarToyotaDtos() {
        return carToyotaDtos;
    }

    public void setCarToyotaDtos(List<CarToyotaDto> carToyotaDtos) {
        this.carToyotaDtos = carToyotaDtos;
    }
}
