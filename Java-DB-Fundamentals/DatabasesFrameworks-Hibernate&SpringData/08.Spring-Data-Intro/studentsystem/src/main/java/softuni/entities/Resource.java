package softuni.entities;

import javax.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {
    private Long id;
    private String name;
    private TypeOfResource typeOfResource;
    private String URL;

    private Course course;
    private License license;

    public Resource() {
    }

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

    @Column(name = "type_of_resource", nullable = false)
    public TypeOfResource getTypeOfResource() {
        return typeOfResource;
    }

    public void setTypeOfResource(TypeOfResource typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    @Column(nullable = false)
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "license_id", referencedColumnName = "id", nullable = false)
    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
