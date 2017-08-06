package softuni.dto.view.Query1;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaleCarDto {
    @Expose
    @SerializedName(value = "make")
    private String carMake;
    @Expose
    @SerializedName(value = "model")
    private String carModel;

    public SaleCarDto() {
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
}
