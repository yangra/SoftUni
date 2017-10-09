package softuni.dto.Export;

import com.google.gson.annotations.Expose;


public class PhotographersOrderedExportJsonDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;

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
}
