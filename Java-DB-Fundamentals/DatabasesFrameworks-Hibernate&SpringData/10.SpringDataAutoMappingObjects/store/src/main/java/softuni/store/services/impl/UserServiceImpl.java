package softuni.store.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.store.entities.Game;
import softuni.store.entities.User;
import softuni.store.entities.enums.Role;
import softuni.store.Utils.ModelParser;
import softuni.store.models.bindingModels.game.BoughtGame;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.user.LoggedInUser;
import softuni.store.models.bindingModels.user.RegisterUser;
import softuni.store.models.bindingModels.user.ShoppingUser;
import softuni.store.models.viewModels.user.UserOwner;
import softuni.store.repositories.UserRepository;
import softuni.store.services.api.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterUser registerUser) {
        User user = ModelParser.getInstance().map(registerUser, User.class);
        if (this.userRepository.findAll().size() > 0) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser login(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        LoggedInUser loggedInUser = null;
        if (user != null) {
            loggedInUser = ModelParser.getInstance().map(user, LoggedInUser.class);
        }
        return loggedInUser;
    }

    @Override
    public RegisterUser getByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        if(user == null){
            return null;
        }
        return ModelParser.getInstance().map(user,RegisterUser.class);
    }

    @Override
    public ShoppingUser getShoppingUserById(Long userId) {
        User user = this.userRepository.findOne(userId);
        return ModelParser.getInstance().map(user,ShoppingUser.class);
    }

    @Override
    public void save(ShoppingUser shoppingUser) {
        User user = this.userRepository.findOne(shoppingUser.getId());
        ModelParser.getInstance().map(shoppingUser,user);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserOwner getUserOwnerById(Long userId) {
        User user = this.userRepository.findOne(userId);
        return ModelParser.getInstance().map(user,UserOwner.class);
    }

}
