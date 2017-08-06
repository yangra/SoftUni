package softuni.dto.binding.XMLDtos;

import softuni.dto.binding.Add.ProductAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportXMLDto {
    @XmlElement(name = "product")
    private List<ProductAddDto> productAddDtos;

    public ProductImportXMLDto() {
    }

    public List<ProductAddDto> getProductAddDtos() {
        return productAddDtos;
    }

    public void setProductAddDtos(List<ProductAddDto> productAddDtos) {
        this.productAddDtos = productAddDtos;
    }
}
