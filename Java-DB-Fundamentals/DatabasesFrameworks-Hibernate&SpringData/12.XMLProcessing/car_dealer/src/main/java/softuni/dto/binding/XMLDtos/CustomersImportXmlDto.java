package softuni.dto.binding.XMLDtos;

import softuni.dto.binding.Import.CustomerImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersImportXmlDto {
    @XmlElement(name="customer")
    private List<CustomerImportDto> customerImportDtos;

    public CustomersImportXmlDto() {
    }

    public List<CustomerImportDto> getCustomerImportDtos() {
        return customerImportDtos;
    }

    public void setCustomerImportDtos(List<CustomerImportDto> customerImportDtos) {
        this.customerImportDtos = customerImportDtos;
    }
}
