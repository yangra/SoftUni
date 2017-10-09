package softuni.dto.Import;

import com.google.gson.annotations.Expose;

/**
 * Created by Yana on 8/13/2017.
 */
public class EmployeeCardImportJsonDto {
    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
