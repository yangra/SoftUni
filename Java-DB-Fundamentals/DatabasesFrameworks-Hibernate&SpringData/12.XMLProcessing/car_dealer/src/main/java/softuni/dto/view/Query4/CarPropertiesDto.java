package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPropertiesDto {
    @Expose
    @SerializedName(value = "Make")
    @XmlAttribute
    private String make;
    @Expose
    @SerializedName(value = "Model")
    @XmlAttribute
    private String model;
    @Expose
    @SerializedName(value = "TravelledDistance")
    @XmlAttribute(name="travelled-distance")
    private Long travelledDistance;

    public CarPropertiesDto() {
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
}
