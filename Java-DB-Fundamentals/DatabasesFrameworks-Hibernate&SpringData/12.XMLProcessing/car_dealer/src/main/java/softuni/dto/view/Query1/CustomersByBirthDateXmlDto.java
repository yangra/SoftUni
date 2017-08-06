package softuni.dto.view.Query1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersByBirthDateXmlDto {
    @XmlElement(name="customer")
    private List<CustomerByBirthDateDto> customerByBirthDateDtos;

    public CustomersByBirthDateXmlDto() {
    }

    public List<CustomerByBirthDateDto> getCustomerByBirthDateDtos() {
        return customerByBirthDateDtos;
    }

    public void setCustomerByBirthDateDtos(List<CustomerByBirthDateDto> customerByBirthDateDtos) {
        this.customerByBirthDateDtos = customerByBirthDateDtos;
    }
}
