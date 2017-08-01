package softuni.store.models.bindingModels.game;


import java.io.Serializable;

public class ShoppingCartGame implements Serializable {
    private Long id;
    private String title;

    public ShoppingCartGame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return " -" + title + "\n";
    }
}
