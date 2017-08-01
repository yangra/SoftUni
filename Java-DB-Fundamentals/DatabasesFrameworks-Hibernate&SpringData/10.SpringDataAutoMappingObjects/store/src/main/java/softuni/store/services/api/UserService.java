package softuni.store.services.api;


import softuni.store.models.bindingModels.game.BoughtGame;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.LoggedInUser;
import softuni.store.models.bindingModels.user.RegisterUser;

public interface UserService {

    void register(RegisterUser registerUser);

    LoggedInUser login(String email, String password);
}
