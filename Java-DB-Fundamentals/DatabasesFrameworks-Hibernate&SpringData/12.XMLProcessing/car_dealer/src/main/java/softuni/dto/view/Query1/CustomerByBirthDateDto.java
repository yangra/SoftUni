package softuni.dto.view.Query1;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Set;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerByBirthDateDto {
    @Expose
    @SerializedName(value = "Id")
    @XmlElement
    private Long id;
    @Expose
    @SerializedName(value = "Name")
    @XmlElement
    private String name;
    @Expose
    @SerializedName(value = "BirthDate")
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @Expose
    @SerializedName(value = "IsYoungDriver")
    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    @Expose
    @SerializedName(value = "Sales")
    @XmlTransient
    private Set<SaleCarDto> sales;

    public CustomerByBirthDateDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<SaleCarDto> getSales() {
        return sales;
    }

    public void setSales(Set<SaleCarDto> sales) {
        this.sales = sales;
    }
}
