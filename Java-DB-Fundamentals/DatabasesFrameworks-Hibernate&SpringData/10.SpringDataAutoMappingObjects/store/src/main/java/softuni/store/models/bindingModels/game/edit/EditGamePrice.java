package softuni.store.models.bindingModels.game.edit;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

public class EditGamePrice implements Serializable{

    @DecimalMin(value = "0.00", message = "Price must be positive number")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    private BigDecimal price;

    public EditGamePrice() {
    }

    public EditGamePrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
