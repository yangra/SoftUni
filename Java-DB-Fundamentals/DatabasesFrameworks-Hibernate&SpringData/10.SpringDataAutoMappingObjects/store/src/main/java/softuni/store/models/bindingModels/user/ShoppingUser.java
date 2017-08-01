package softuni.store.models.bindingModels.user;

import softuni.store.models.bindingModels.game.ShoppingCartGame;

import java.util.Set;

/**
 * Created by Yana on 8/1/2017.
 */
public class ShoppingUser {
    private Long id;
    private Set<ShoppingCartGame> shoppingCartGames;
    private Set<ShoppingCartGame> boughtGames;

    public ShoppingUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ShoppingCartGame> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<ShoppingCartGame> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    public Set<ShoppingCartGame> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<ShoppingCartGame> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
