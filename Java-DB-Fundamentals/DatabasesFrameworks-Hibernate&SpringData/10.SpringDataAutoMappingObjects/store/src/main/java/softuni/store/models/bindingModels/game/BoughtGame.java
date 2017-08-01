package softuni.store.models.bindingModels.game;


import java.io.Serializable;

public class BoughtGame implements Serializable{
    private Long id;

    public BoughtGame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
