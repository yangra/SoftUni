package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

public class ProductsNameAndPriceDto {
    @Expose
    private String name;
    @Expose
    private String price;


    public ProductsNameAndPriceDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
