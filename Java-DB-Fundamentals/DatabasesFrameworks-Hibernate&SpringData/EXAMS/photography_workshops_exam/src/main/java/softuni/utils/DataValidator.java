package softuni.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class DataValidator {
    public static <T> String getInvalidParameterMessage(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        for (ConstraintViolation<T> constraint : constraints) {
            return constraint.getMessage();
        }
        return null;
    }

    public static <T> boolean validate(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validate(target);
        return constraints.size() == 0;
    }
    public static <T> boolean validateField(T target,String field) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory.getValidator().validateProperty(target,field);
        return constraints.size() == 0;
    }
}
