package softuni.store.Utils;


import softuni.store.models.bindingModels.user.LoggedInUser;

public class Session {
    private static LoggedInUser loggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedUser) {
        loggedInUser = loggedUser;
    }
}
