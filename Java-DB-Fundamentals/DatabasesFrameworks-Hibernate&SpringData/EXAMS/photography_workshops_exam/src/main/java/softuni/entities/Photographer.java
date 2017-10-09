package softuni.entities;

import softuni.validations.Phone;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Camera primaryCamera;
    private Camera secondaryCamera;

    private Set<Lens> lenses;
    private Set<Accessory> accessories;

    public Photographer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne
    @JoinColumn(name="primary_camera_id")
    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    @OneToOne
    @JoinColumn(name="secondary_camera_id")
    public Camera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(Camera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "photographer_id")
    public Set<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }
}
