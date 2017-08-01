package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.entities.enums.Role;
import softuni.store.models.bindingModels.game.ManipulateGame;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class DeleteCommand extends Command {
    public DeleteCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser()==null){
            return "No user logged in.";
        }
        if(Session.getLoggedInUser().getRole()!= Role.ADMIN){
            return "Only admins can delete games.";
        }
        Long gameId = Long.parseLong(params[0]);
        ManipulateGame manipulateGame = super.getGameService().getManipulateGame(gameId);
        if(manipulateGame == null){
            return "Cannot delete game. Invalid id.";
        }
        super.getGameService().deleteGame(gameId);
        return String.format("Deleted %s", manipulateGame.getTitle());
    }
}
