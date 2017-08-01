package softuni.store.validations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class DoublePrecisionValidator implements ConstraintValidator<DoublePrecision, Double> {
    private boolean positive;
    private int fraction;

    @Override
    public void initialize(DoublePrecision doublePrecision) {
        this.positive = doublePrecision.positive();
        this.fraction = doublePrecision.fraction();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if (this.positive && value < 0) {
            return false;
        }

        String[] number = value.toString().split("\\.");

        if(number.length == 1){
            return true;
        }

        if (number[1].length()>this.fraction){
            return false;
        }

        return true;
    }
}
