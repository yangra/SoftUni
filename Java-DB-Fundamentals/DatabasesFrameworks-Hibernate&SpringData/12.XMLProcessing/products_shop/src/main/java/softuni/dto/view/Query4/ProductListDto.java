package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductListDto {
    @Expose
    @XmlAttribute(name="count")
    private int count;
    @Expose
    @XmlElement(name="product")
    private List<ProductsNameAndPriceDto> products;

    public ProductListDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductsNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsNameAndPriceDto> products) {
        this.products = products;
    }
}
