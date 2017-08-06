package softuni.dto.view.Query3;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersLocalXmlDto {
    @XmlElement(name="supplier")
    private List<SupplierLocalDto> supplierLocalDtos;

    public SuppliersLocalXmlDto() {
    }

    public List<SupplierLocalDto> getSupplierLocalDtos() {
        return supplierLocalDtos;
    }

    public void setSupplierLocalDtos(List<SupplierLocalDto> supplierLocalDtos) {
        this.supplierLocalDtos = supplierLocalDtos;
    }
}
