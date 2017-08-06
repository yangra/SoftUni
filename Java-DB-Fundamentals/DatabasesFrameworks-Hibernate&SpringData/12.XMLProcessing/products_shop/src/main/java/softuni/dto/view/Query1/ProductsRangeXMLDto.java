package softuni.dto.view.Query1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsRangeXMLDto {
    @XmlElement(name="product")
    private List<ProductRangeDto> productRangeDtos;

    public ProductsRangeXMLDto() {
    }

    public List<ProductRangeDto> getProductRangeDtos() {
        return productRangeDtos;
    }

    public void setProductRangeDtos(List<ProductRangeDto> productRangeDtos) {
        this.productRangeDtos = productRangeDtos;
    }
}
