package softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="venues")
public class Venue {
    private Long id;
    private String name;
    private Integer capacity;
    private  String town;

    private Set<Wedding> weddings;

    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Basic

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @ManyToMany
    @JoinTable(name = "weddings_venues",
            joinColumns = @JoinColumn(name = "venue_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="wedding_id", referencedColumnName = "id"))
    public Set<Wedding> getWeddings() {
        return weddings;
    }

    public void setWeddings(Set<Wedding> weddings) {
        this.weddings = weddings;
    }
}
