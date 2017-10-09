package softuni.dto.Export;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlTransient
    private BigDecimal pricePerParticipant;
    @XmlElement(name = "participants")
    private ParticipantsExportXmlDto participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public ParticipantsExportXmlDto getParticipants() {
        return participants;
    }

    public void setParticipants(ParticipantsExportXmlDto participants) {
        this.participants = participants;
    }

    @XmlAttribute(name="total-profit")
    public String getProfit() {
        return String.valueOf(pricePerParticipant
                .multiply(BigDecimal.valueOf(participants.getCount()))
                .multiply(BigDecimal.valueOf(0.8)));
    }
}
