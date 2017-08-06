package softuni.dto.view.Query2;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsDto {

    @Expose
    @XmlAttribute(name="first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private Set<ProductSoldDto> soldProducts;

    public UserSoldProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductSoldDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
