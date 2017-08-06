package softuni.dto.view.Query6;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.dto.view.Query4.CarPropertiesDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalePropertiesDto {
    @Expose
    @XmlElement(name = "car")
    private CarPropertiesDto car;
    @Expose
    @XmlElement(name="customer-name")
    private String customerName;
    @Expose
    @SerializedName(value = "Discount")
    @XmlElement
    private Integer discount;
    @Expose
    @XmlElement
    private BigDecimal price;
    @Expose
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public CarPropertiesDto getCar() {
        return car;
    }

    public void setCar(CarPropertiesDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public SalePropertiesDto() {

    }
}
