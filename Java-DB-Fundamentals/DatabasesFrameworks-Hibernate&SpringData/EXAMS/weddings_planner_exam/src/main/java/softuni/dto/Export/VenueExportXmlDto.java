package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class VenueExportXmlDto {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private Integer capacity;
    @XmlTransient
    private  String town;

    @XmlTransient
    private Set<String> weddings;

    @XmlElement(name="weddings-count")
    public Integer getWeddingsCount(){
        return weddings.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Set<String> getWeddings() {
        return weddings;
    }

    public void setWeddings(Set<String> weddings) {
        this.weddings = weddings;
    }
}
