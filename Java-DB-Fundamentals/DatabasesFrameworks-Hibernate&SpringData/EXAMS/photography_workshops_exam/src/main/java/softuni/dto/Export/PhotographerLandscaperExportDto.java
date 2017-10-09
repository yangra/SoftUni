package softuni.dto.Export;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Camera;
import softuni.entities.Lens;

import java.util.Set;

public class PhotographerLandscaperExportDto {
    @Expose
    @SerializedName(value="FirstName")
    private String firstName;
    @Expose
    @SerializedName(value="LastName")
    private String lastName;

    @Expose
    @SerializedName(value="CameraMake")
    private String primaryCameraMake;

    @Expose
    private Integer LensesCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryCameraMake() {
        return primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public Integer getLensesCount() {
        return LensesCount;
    }

    public void setLensesCount(Integer lensesCount) {
        LensesCount = lensesCount;
    }
}
