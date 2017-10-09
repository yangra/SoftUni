package softuni.dto.Import;

import com.google.gson.annotations.Expose;


public class AgencyImportDto {
    @Expose
    private String name;
    @Expose
    private Integer employeesCount;
    @Expose
    private  String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
