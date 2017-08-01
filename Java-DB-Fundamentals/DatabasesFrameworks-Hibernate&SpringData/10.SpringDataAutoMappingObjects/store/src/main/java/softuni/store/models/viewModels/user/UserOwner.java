package softuni.store.models.viewModels.user;

import softuni.store.models.viewModels.game.OwnedGameView;

import java.util.Set;


public class UserOwner {
    private Long id;
    private Set<OwnedGameView> boughtGames;

    public UserOwner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<OwnedGameView> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<OwnedGameView> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
