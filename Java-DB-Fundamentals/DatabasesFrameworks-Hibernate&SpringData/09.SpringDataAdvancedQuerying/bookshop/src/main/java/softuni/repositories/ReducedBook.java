package softuni.repositories;


import org.springframework.stereotype.Component;
import softuni.entities.AgeRestriction;
import softuni.entities.EditionType;

import java.math.BigDecimal;

@Component
public interface ReducedBook  {

    String getTitle();

    void setTitle();

    EditionType getEditionType();

    void setEditionType();

    AgeRestriction getAgeRestriction();

    void setAgeRestriction();

    BigDecimal getPrice();

    void setPrice();
}
