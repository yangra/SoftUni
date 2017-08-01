package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.models.viewModels.game.OwnedGameView;
import softuni.store.models.viewModels.user.UserOwner;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import java.util.List;
import java.util.Set;

public class OwnedGamesCommand extends Command {
    public OwnedGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser()==null){
            return "No user logged in";
        }

        Long userId = Session.getLoggedInUser().getId();
        UserOwner userOwner = super.getUserService().getUserOwnerById(userId);
        Set<OwnedGameView> ownedGames = userOwner.getBoughtGames();
        StringBuilder sb = new StringBuilder();
        for (OwnedGameView ownedGame : ownedGames) {
            sb.append(ownedGame.getTitle());
            sb.append("\n");
        }
        return sb.toString();
    }
}
