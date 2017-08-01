package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import java.util.List;

public class BuyGamesCommand extends Command{
    public BuyGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser() == null){
            return "No user logged in.";
        }

        Long userId = Session.getLoggedInUser().getId();
        ShoppingUser shoppingUser = super.getUserService().getShoppingUserById(userId);
        if(shoppingUser.getShoppingCartGames().isEmpty()){
            return "There's nothing to buy. Shopping cart is empty.";
        }

        StringBuilder sb = new StringBuilder();
        for (ShoppingCartGame shoppingCartGame : shoppingUser.getShoppingCartGames()) {
            shoppingUser.getBoughtGames().add(shoppingCartGame);
            sb.append(shoppingCartGame.toString());
        }

        shoppingUser.getShoppingCartGames().clear();
        super.getUserService().save(shoppingUser);

        return String.format("Successfully bought games:\n%s",sb.toString());
    }
}
