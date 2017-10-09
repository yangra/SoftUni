package softuni.dto.Import;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsImportXmlDto {
    @XmlElement(name = "product")
    List<ProductImportXmlDto> productImportXmlDtos;

    public List<ProductImportXmlDto> getProductImportXmlDtos() {
        return productImportXmlDtos;
    }

    public void setProductImportXmlDtos(List<ProductImportXmlDto> productImportXmlDtos) {
        this.productImportXmlDtos = productImportXmlDtos;
    }
}
