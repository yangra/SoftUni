package softuni.dto.view.Query5;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesDto {
    @Expose
    @XmlAttribute(name ="full-name")
    private String fullName;
    @Expose
    @XmlAttribute(name = "bought-cars")
    private Integer boughtCars;
    @Expose
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerSalesDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Integer boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
