package softuni.dto.Import;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerTrainerImportXmlDto {
    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;

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
    @XmlValue
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        String[] params = fullName.split("\\s+");
        this.firstName = params[0];
        this.lastName = params[1];
    }
}
