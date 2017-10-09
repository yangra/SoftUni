package softuni.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "dslr")
public class DSLRCamera extends Camera {
    private Integer maxShutterSpeed;

    public DSLRCamera() {
    }

    @Override
    public String type() {
        return "DSLR";
    }

    @Column(name = "max_shutter_speed")
    public Integer getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}
