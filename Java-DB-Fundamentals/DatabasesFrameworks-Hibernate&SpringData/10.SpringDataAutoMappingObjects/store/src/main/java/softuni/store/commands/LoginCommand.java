package softuni.store.commands;


import softuni.store.Utils.Session;
import softuni.store.models.bindingModels.user.LoggedInUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class LoginCommand extends Command {
    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        String email = params[0];
        String password = params[1];
        if (Session.getLoggedInUser() != null) {
            return "There is another user logged in.";
        }

        LoggedInUser loggedInUser = super.getUserService().login(email, password);
        if (loggedInUser == null) {
            return "Incorrect email/password";
        }

        Session.setLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s", loggedInUser.getFullName());
    }
}
