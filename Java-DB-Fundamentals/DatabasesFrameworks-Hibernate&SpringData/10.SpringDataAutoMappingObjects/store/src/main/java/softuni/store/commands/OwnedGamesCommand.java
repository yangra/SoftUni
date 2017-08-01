package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.viewModels.game.OwnedGameView;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import java.util.List;

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
        List<OwnedGameView> ownedGames = super.getGameService().getOwnedGames(userId);
        StringBuilder sb = new StringBuilder();
        for (OwnedGameView ownedGame : ownedGames) {
            sb.append(ownedGame.getTitle());
            sb.append("\n");
        }
        return sb.toString();
    }
}
