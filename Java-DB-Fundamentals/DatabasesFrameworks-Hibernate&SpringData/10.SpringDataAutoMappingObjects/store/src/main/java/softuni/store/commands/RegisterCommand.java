package softuni.store.commands;


import softuni.store.Utils.DataValidator;
import softuni.store.models.bindingModels.user.RegisterUser;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RegisterCommand extends Command {

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(params[0]);
        registerUser.setPassword(params[1]);
        registerUser.setConfirmPassword(params[2]);
        registerUser.setFullName(params[3]);

        if (!DataValidator.checkIsValid(registerUser)) {
            return DataValidator.getInvalidParameterMessage(registerUser);
        }
        try{
            super.getUserService().register(registerUser);
        }catch(Exception e){
            return e.getMessage();
        }

        return String.format("%s was registered", params[3]);
    }
}
