package softuni.entities;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
public class License {
    private Long id;
    private String name;

    public License() {
    }

    @Id
    @GeneratedValue
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
}
