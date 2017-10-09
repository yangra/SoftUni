package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TownExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private Long population;
    @XmlAttribute(name = "town_clients")
    private Long clients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }
}
