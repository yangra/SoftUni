package softuni.entities;

import softuni.entities.enums.Size;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "gift")
public class Gift extends Present {
    private String name;
    private Size size;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Basic
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String type() {
        return "gift";
    }
}
