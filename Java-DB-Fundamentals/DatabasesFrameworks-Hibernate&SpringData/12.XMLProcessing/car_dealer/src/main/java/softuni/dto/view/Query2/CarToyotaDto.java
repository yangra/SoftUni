package softuni.dto.view.Query2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarToyotaDto {
    @Expose
    @SerializedName(value = "Id")
    @XmlAttribute
    private Long id;
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

    public CarToyotaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
