package softuni.dto.Import;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Yana on 8/13/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportXmlDto {
    @NotNull
    @XmlAttribute
    private String name;
    @NotNull
    @XmlAttribute
    private Long clients;
    @NotNull
    @XmlElement
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
