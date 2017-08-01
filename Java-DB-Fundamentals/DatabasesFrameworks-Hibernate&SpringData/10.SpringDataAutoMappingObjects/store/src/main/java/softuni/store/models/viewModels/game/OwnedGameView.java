package softuni.store.models.viewModels.game;


import java.io.Serializable;

public class OwnedGameView implements Serializable {
    private String title;

    public OwnedGameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
