package softuni.dto.view.Query3;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewDto {
    @Expose
    @XmlAttribute(name="name")
    private String category;
    @Expose
    @XmlElement(name = "products-count")
    private Long productCount;
    @Expose
    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;
    @Expose
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoryViewDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
