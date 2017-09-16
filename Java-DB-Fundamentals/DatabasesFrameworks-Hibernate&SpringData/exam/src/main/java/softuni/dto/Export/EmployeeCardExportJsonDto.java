package softuni.dto.Export;

import com.google.gson.annotations.Expose;

/**
 * Created by Yana on 8/13/2017.
 */
public class EmployeeCardExportJsonDto {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
