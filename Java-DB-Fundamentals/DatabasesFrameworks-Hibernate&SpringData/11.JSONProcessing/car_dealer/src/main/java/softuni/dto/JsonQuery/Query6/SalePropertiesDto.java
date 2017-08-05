package softuni.dto.JsonQuery.Query6;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.dto.JsonQuery.Query4.CarPropertiesDto;

import java.math.BigDecimal;

public class SalePropertiesDto {
    @Expose
    private CarPropertiesDto car;
    @Expose
    private String customerName;
    @Expose
    @SerializedName(value = "Discount")
    private Integer discount;
    @Expose
    private BigDecimal price;
    @Expose
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
