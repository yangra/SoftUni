package softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lenses")
public class Lens {
    private Long id;
    private String make;
    private Integer focalLength;
    private Double maxAperture;
    private String compatibleWith;

    private Photographer owner;

    public Lens() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="focal_length")
    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    @Column(name = "max_aperture")
    public Double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    @Column(name = "compatible_with")
    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    @ManyToOne
    @JoinColumn(name = "photographer_id", referencedColumnName = "id")
    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }

    @Basic
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
