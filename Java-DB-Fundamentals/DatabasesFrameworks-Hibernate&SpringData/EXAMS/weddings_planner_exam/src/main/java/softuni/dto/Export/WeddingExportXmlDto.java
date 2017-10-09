package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Yana on 8/11/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WeddingExportXmlDto {
    @XmlAttribute
    private BigDecimal cash;
    @XmlAttribute
    private Integer presents;
    @XmlElement(name="bride")
    private String brideFullName;

    @XmlElement(name="bridegroom")
    private String bridegroomFullName;

    @XmlElementWrapper(name = "guests")
    @XmlElement(name="guest")
    private Set<GuestExportXmlDto> invitations;

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Integer getPresents() {
        return presents;
    }

    public void setPresents(Integer presents) {
        this.presents = presents;
    }

    public String getBrideFullName() {
        return brideFullName;
    }

    public void setBrideFullName(String brideFullName) {
        this.brideFullName = brideFullName;
    }

    public String getBridegroomFullName() {
        return bridegroomFullName;
    }

    public void setBridegroomFullName(String bridegroomFullName) {
        this.bridegroomFullName = bridegroomFullName;
    }

    public Set<GuestExportXmlDto> getInvitations() {
        return invitations;
    }

    public void setInvitations(Set<GuestExportXmlDto> invitations) {
        this.invitations = invitations;
    }
}
