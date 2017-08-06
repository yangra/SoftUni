package softuni.dto.binding.XMLDtos;

import softuni.dto.binding.Import.CarImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsImportXmlDto {
    @XmlElement(name="car")
    private List<CarImportDto> carImportDtos;

    public CarsImportXmlDto() {
    }

    public List<CarImportDto> getCarImportDtos() {
        return carImportDtos;
    }

    public void setCarImportDtos(List<CarImportDto> carImportDtos) {
        this.carImportDtos = carImportDtos;
    }
}
