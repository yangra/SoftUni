package softuni.store.validations;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = DoublePrecisionValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoublePrecision {
    String message() default "Invalid double precision";
    boolean positive() default false;
    int fraction() default 2;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
