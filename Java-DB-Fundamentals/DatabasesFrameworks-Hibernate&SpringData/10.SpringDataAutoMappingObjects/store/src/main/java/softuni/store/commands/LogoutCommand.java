package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.user.LoggedInUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class LogoutCommand extends Command {
    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if(Session.getLoggedInUser()==null){
            return "Cannot log out. No user was logged in.";
        }

        LoggedInUser loggedInUser = Session.getLoggedInUser();
        Session.setLoggedInUser(null);
        return String.format("User %s successfully logged out", loggedInUser.getFullName());
    }
}
