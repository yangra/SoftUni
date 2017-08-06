package softuni.dto.view.Query4;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsXmlDto {
    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name="travelled-distance")
    private Long travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartNamePriceDto> parts;

    public CarPartsXmlDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<PartNamePriceDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartNamePriceDto> parts) {
        this.parts = parts;
    }
}
