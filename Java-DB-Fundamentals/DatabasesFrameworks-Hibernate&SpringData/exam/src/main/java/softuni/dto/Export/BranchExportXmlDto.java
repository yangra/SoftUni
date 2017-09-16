package softuni.dto.Export;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "town")
    private String townName;
    @XmlAttribute(name = "total_clients")
    private Long clients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }
}
