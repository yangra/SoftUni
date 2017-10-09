package softuni.entities;

import softuni.entities.enums.Family;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invitations")
public class Invitation {
    private Long id;
    @NotNull
    private Wedding wedding;
    @NotNull
    private Person guest;
    private Present present;
    private Boolean attending;
    @NotNull
    private Family family;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name= "wedding_id", referencedColumnName = "id")
    public Wedding getWedding() {
        return wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
    }

    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    public Person getGuest() {
        return guest;
    }

    public void setGuest(Person guest) {
        this.guest = guest;
    }

    @OneToOne
    @JoinColumn(name = "present_id", referencedColumnName = "id")
    public Present getPresent() {
        return present;
    }

    public void setPresent(Present present) {
        this.present = present;
    }

    @Basic
    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    @Enumerated(EnumType.STRING)
    @Basic
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }


}
