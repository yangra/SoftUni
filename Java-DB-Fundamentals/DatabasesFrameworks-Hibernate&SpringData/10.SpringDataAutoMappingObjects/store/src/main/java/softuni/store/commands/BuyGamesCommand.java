package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
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
        List<ShoppingCartGame> shoppingCartGames = super.getGameService().getShoppingCartById(userId);
        if(shoppingCartGames.isEmpty()){
            return "There's nothing to buy. Shopping cart is empty.";
        }
        for (ShoppingCartGame shoppingCartGame : shoppingCartGames) {
            Long gameId = shoppingCartGame.getId();
            super.getGameService().buyGame(gameId,userId);
        }
        StringBuilder sb = new StringBuilder();
        for (ShoppingCartGame shoppingCartGame : shoppingCartGames) {
            sb.append(shoppingCartGame.toString());
        }
        return String.format("Successfully bought games:\n%s",sb.toString());
    }
}
