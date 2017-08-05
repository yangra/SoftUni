package softuni.dto.binding.Add;



import com.google.gson.annotations.Expose;
import softuni.dto.binding.CategoryDto;
import softuni.dto.binding.UserDto;

import java.math.BigDecimal;
import java.util.Set;

public class ProductAddDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    private UserDto buyer;
    private UserDto seller;
    private Set<CategoryDto> categories;

    public ProductAddDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }
}
