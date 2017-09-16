package softuni.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Yana on 8/13/2017.
 */
@Entity
@Table(name = "branches")
public class Branch {
    private Long id;
    private String name;
    private Town town;

    Set<Product> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="town_id", referencedColumnName = "id", nullable = false)
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "branch")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
