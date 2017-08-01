package softuni.store.commands;


import softuni.store.models.viewModels.game.GameDetailsView;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class GameDetailsCommand extends Command{

    public GameDetailsCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        GameDetailsView gameDetailsView = super.getGameService().getGameDetailsByName(params[0]);
        if(gameDetailsView == null){
            return "There is no game with that name in the database.";
        }

        return gameDetailsView.toString();
    }
}
