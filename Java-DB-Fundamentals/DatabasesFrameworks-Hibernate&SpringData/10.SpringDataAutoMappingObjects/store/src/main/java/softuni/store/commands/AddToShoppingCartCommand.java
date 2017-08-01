package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class AddToShoppingCartCommand extends Command {
    public AddToShoppingCartCommand(UserService userService, GameService gameService) {
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
            return "Cannot add to shopping cart. There is no such game in the database";
        }

        Long userId = Session.getLoggedInUser().getId();
        ShoppingUser shoppingUser = super.getUserService().getShoppingUserById(userId);
        if(shoppingUser.getBoughtGames().contains(shoppingCartGame)){
            return "Cannot add this game to your shopping cart. It's already bought once.";
        }

        if(shoppingUser.getShoppingCartGames().contains(shoppingCartGame)){
            return "Cannot add to shopping cart.The game is already in the cart.";
        }

        shoppingUser.getShoppingCartGames().add(shoppingCartGame);
        super.getUserService().save(shoppingUser);
        return String.format("%s added to cart",shoppingCartGame.getTitle());
    }
}
