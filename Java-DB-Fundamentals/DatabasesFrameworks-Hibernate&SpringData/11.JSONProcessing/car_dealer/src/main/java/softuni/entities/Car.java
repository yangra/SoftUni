package softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    private Long id;
    private String make;
    private String model;
    private Long travelledDistance;

    private Set<Part> parts;

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="cars_parts",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name ="part_id", referencedColumnName = "id"))
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
