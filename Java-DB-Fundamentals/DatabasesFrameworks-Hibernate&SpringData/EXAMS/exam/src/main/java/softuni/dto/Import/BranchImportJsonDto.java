package softuni.dto.Import;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

/**
 * Created by Yana on 8/13/2017.
 */
public class BranchImportJsonDto {
    @NotNull
    @Expose
    private String name;
    @NotNull
    @Expose
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
