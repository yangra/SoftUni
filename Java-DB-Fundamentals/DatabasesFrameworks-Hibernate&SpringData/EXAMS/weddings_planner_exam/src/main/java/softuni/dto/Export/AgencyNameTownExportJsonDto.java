package softuni.dto.Export;

import com.google.gson.annotations.Expose;

/**
 * Created by Yana on 8/11/2017.
 */
public class AgencyNameTownExportJsonDto {
    @Expose
    private String name;
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
