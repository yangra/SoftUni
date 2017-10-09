package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantsExportXmlDto {

    @XmlElement(name="participant")
    private Set<ParticipantExportXmlDto> participants;


    public Set<ParticipantExportXmlDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantExportXmlDto> participants) {
        this.participants = participants;
    }

    @XmlAttribute
    public Integer getCount() {
        return participants.size();
    }


}
