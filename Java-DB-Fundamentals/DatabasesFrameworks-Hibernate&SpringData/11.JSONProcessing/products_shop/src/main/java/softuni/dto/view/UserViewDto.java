package softuni.dto.view;


import com.google.gson.annotations.Expose;

public class UserViewDto {

    private String firstName;

    private String lastName;

    public UserViewDto() {
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
}
