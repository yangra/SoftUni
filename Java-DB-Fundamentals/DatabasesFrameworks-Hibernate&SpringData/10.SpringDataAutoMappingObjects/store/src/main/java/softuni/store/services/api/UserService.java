package softuni.store.services.api;


import softuni.store.models.bindingModels.game.BoughtGame;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.LoggedInUser;
import softuni.store.models.bindingModels.user.RegisterUser;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.models.viewModels.user.UserOwner;

public interface UserService {

    void register(RegisterUser registerUser);

    LoggedInUser login(String email, String password);

    RegisterUser getByEmail(String email);

    ShoppingUser getShoppingUserById(Long userId);

    void save(ShoppingUser shoppingUser);

    UserOwner getUserOwnerById(Long userId);
}
