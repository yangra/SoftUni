package softuni.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Yana on 8/13/2017.
 */
@Entity
@Table(name = "towns")
public class Town {
    private Long id;
    private String name;
    private Long population;

    private Set<Branch> branches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @OneToMany(mappedBy = "town")
    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }
}
