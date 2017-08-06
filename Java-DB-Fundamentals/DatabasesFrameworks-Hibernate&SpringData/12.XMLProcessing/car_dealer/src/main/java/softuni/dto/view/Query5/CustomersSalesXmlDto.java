package softuni.dto.view.Query5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersSalesXmlDto {
    @XmlElement(name="customer")
    private List<CustomerSalesDto> customerSalesDtos;

    public CustomersSalesXmlDto() {
    }

    public List<CustomerSalesDto> getCustomerSalesDtos() {
        return customerSalesDtos;
    }

    public void setCustomerSalesDtos(List<CustomerSalesDto> customerSalesDtos) {
        this.customerSalesDtos = customerSalesDtos;
    }
}
