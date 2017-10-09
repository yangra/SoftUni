package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "weddings")
public class Wedding {
    private Long id;
    @NotNull
    private Person bride;
    @NotNull
    private Person bridegroom;
    @NotNull
    private Date date;
    @NotNull
    private Agency agency;

    private Set<Venue> venues;
    private Set<Invitation> invitations;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "bride_id")
    public Person getBride() {
        return bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    @OneToOne
    @JoinColumn(name = "bridegroom_id")
    public Person getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(Person bridegroom) {
        this.bridegroom = bridegroom;
    }

    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @ManyToOne
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @ManyToMany
    @JoinTable(name = "weddings_venues",
            joinColumns = @JoinColumn(name = "wedding_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="venue_id", referencedColumnName = "id"))
    public Set<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    @OneToMany(mappedBy = "wedding")
    public Set<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }
}
