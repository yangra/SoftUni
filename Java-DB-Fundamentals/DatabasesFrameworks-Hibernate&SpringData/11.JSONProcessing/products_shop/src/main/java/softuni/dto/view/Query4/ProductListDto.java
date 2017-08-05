package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductListDto {
    @Expose
    private int count;
    @Expose
    private List<ProductsNameAndPriceDto> products;

    public ProductListDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductsNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsNameAndPriceDto> products) {
        this.products = products;
    }
}
