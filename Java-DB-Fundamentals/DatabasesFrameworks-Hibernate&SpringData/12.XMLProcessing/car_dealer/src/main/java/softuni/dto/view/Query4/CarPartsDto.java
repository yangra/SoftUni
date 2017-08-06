package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;


public class CarPartsDto {
    @Expose
    @SerializedName(value = "car" )
    private CarPropertiesDto car;

    @Expose
    private Set<PartNamePriceDto> parts;

    public CarPartsDto() {
    }

    public CarPropertiesDto getCar() {
        return car;
    }

    public void setCar(CarPropertiesDto car) {
        this.car = car;
    }

    public Set<PartNamePriceDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartNamePriceDto> parts) {
        this.parts = parts;
    }
}
