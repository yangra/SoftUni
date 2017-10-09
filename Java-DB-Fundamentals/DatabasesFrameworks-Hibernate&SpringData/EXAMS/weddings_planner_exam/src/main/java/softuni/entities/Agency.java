package softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="agencies")
public class Agency {
    private Long id;
    private String name;
    private Integer employeesCount;
    private  String town;

    private Set<Wedding> weddings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "employees_count")
    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    @Basic
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "agency")
    public Set<Wedding> getWeddings() {
        return weddings;
    }

    public void setWeddings(Set<Wedding> weddings) {
        this.weddings = weddings;
    }
}
