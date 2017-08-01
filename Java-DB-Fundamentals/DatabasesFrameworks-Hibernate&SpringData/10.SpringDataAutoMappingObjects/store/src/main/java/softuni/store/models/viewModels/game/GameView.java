package softuni.store.models.viewModels.game;


import java.io.Serializable;
import java.math.BigDecimal;

public class GameView implements Serializable{
    private String title;
    private BigDecimal price;

    public GameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.title, this.price);
    }
}
