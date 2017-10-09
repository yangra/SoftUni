package softuni.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "cash")
public class Cash extends Present{
    private BigDecimal cashAmount;

    @Column(name="cash_amount")
    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    @Override
    public String type() {
        return "cash";
    }
}

