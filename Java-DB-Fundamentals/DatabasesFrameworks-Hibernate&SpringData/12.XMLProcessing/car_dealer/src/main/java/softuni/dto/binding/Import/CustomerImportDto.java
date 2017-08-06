package softuni.dto.binding.Import;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImportDto {
    @Expose
    @XmlAttribute
    private String name;
    @Expose
    @XmlElement(name="birth-date")
    private Date birthDate;
    @Expose
    @XmlElement(name="is-young-driver")
    private Boolean isYoungDriver;

    public CustomerImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}

