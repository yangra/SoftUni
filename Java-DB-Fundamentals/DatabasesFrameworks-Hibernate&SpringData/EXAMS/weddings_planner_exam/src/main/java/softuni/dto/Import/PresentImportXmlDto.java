package softuni.dto.Import;

import softuni.entities.enums.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

/**
 * Created by Yana on 8/10/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentImportXmlDto {
    @XmlAttribute(name = "amount")
    private BigDecimal cashAmount;
    @XmlAttribute(name="present-name")
    private String name;
    @XmlAttribute
    private Size size;
    @XmlAttribute(name="invitation-id")
    private String owner;
    @XmlAttribute
    private String type;

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
