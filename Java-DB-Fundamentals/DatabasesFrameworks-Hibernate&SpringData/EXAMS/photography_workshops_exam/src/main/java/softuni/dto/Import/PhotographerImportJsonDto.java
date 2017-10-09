package softuni.dto.Import;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PhotographerImportJsonDto {
    @NotNull
    @Expose
    private String firstName;
    @NotNull
    @Length(min=2,max=50)
    @Expose
    private String lastName;

    @Expose
    @SerializedName(value = "phone")
    private String phone;

    @Expose
    @SerializedName(value = "lenses")
    private List<Integer> lensIds;

    public PhotographerImportJsonDto() {
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getLensIds() {
        return lensIds;
    }

    public void setLensIds(List<Integer> lensIds) {
        this.lensIds = lensIds;
    }
}
