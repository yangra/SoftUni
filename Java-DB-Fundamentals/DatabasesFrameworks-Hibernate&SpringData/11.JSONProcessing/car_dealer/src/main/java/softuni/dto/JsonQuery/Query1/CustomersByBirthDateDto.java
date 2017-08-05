package softuni.dto.JsonQuery.Query1;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Set;

public class CustomersByBirthDateDto {
    @Expose
    @SerializedName(value = "Id")
    private Long id;
    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    @SerializedName(value = "BirthDate")
    private Date birthDate;
    @Expose
    @SerializedName(value = "IsYoungDriver")
    private Boolean isYoungDriver;

    @Expose
    @SerializedName(value = "Sales")
    private Set<SaleCarDto> sales;

    public CustomersByBirthDateDto() {
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
