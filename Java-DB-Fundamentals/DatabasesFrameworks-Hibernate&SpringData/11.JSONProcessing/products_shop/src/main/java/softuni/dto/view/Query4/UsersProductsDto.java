package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import java.util.Set;

public class UsersProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
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
