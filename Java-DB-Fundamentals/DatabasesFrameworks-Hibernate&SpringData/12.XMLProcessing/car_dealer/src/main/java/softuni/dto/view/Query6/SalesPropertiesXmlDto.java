package softuni.dto.view.Query6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesPropertiesXmlDto {
    @XmlElement(name = "sale")
    private List<SalePropertiesDto> salePropertiesDtos;

    public SalesPropertiesXmlDto() {
    }

    public List<SalePropertiesDto> getSalePropertiesDtos() {
        return salePropertiesDtos;
    }

    public void setSalePropertiesDtos(List<SalePropertiesDto> salePropertiesDtos) {
        this.salePropertiesDtos = salePropertiesDtos;
    }
}
