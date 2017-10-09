package softuni.dto.Export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Yana on 8/13/2017.
 */
public class EmployeeExportJsonDto {
    @Expose
    @SerializedName(value = "full_name")
    private String employeeFullName;
    @Expose
    private String position;
    @Expose
    @SerializedName(value = "number")
    private String employeeCardNumber;

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeCardNumber() {
        return employeeCardNumber;
    }

    public void setEmployeeCardNumber(String employeeCardNumber) {
        this.employeeCardNumber = employeeCardNumber;
    }
}
