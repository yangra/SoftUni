package softuni.entities;

import javax.persistence.*;

/**
 * Created by Yana on 8/13/2017.
 */
@Entity
@Table(name = "products")
public class Product {
    private Long id;
    private String name;
    private Long clients;

    private Branch branch;

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

    @Column(nullable = false)
    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }

    @ManyToOne
    @JoinColumn(name="branch_id", referencedColumnName = "id", nullable = false)
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
