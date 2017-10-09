package softuni.dto.Import;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopImportXmlDto {
    @XmlAttribute(name="name")
    private String name;
    @XmlAttribute(name="start-date")
    private Date startDate;
    @XmlAttribute(name="end-date")
    private Date endDate;
    @XmlAttribute
    private String location;
    @XmlAttribute(name="price")
    private BigDecimal pricePerParticipant;

    @XmlElement(name="trainer")
    private PhotographerTrainerImportXmlDto trainer;
    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    private Set<PhotographerParticipantImportXmlDto> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public PhotographerTrainerImportXmlDto getTrainer() {
        return trainer;
    }

    public void setTrainer(PhotographerTrainerImportXmlDto trainer) {
        this.trainer = trainer;
    }

    public Set<PhotographerParticipantImportXmlDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<PhotographerParticipantImportXmlDto> participants) {
        this.participants = participants;
    }
}
