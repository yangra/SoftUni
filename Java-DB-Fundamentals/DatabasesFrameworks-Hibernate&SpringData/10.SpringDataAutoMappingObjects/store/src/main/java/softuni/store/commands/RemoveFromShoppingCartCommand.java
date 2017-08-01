package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class RemoveFromShoppingCartCommand extends Command{
    public RemoveFromShoppingCartCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser() == null){
            return "No user logged in.";
        }

        String title = params[0];
        ShoppingCartGame shoppingCartGame = super.getGameService().getShoppingCartGameByName(title);
        if(shoppingCartGame==null){
            return "Cannot remove from shopping cart. There is no such game in the database";
        }

        Long userId = Session.getLoggedInUser().getId();
        Long gameId = shoppingCartGame.getId();
        ShoppingUser shoppingUser = super.getUserService().getShoppingUserById(userId);
        if(!shoppingUser.getShoppingCartGames().contains(shoppingCartGame)){
            return "Cannot remove from shopping cart.The game is not in the cart.";
        }

        shoppingUser.getShoppingCartGames().remove(shoppingCartGame);
        super.getUserService().save(shoppingUser);

        return String.format("%s removed from cart",shoppingCartGame.getTitle());

    }
}
