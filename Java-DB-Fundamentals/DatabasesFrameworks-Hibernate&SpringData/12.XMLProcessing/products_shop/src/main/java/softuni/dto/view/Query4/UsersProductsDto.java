package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.Set;
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersProductsDto {
    @Expose
    @XmlAttribute(name="first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name="last-name")
    private String lastName;
    @Expose
    @XmlAttribute
    private Integer age;
    @Expose
    @XmlElement(name="sold-products")
    private ProductListDto soldProducts;

    public UsersProductsDto() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductListDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductListDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
