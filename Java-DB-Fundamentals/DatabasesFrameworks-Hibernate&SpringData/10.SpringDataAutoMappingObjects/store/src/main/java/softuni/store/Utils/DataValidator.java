package softuni.store.Utils;


import softuni.store.models.bindingModels.user.RegisterUser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataValidator {
    public static <T> String getInvalidParameterMessage(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        for (ConstraintViolation<T> constraint : constraints) {
            return constraint.getMessage();
        }
        return null;
    }

    public static <T> boolean checkIsValid(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        for (ConstraintViolation<T> constraint : constraints) {
            return false;
        }
        return true;
    }
}
