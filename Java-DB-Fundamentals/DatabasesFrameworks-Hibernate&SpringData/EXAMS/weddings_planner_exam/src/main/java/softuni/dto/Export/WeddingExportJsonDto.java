package softuni.dto.Export;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Agency;
import softuni.entities.Invitation;
import softuni.entities.Person;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class WeddingExportJsonDto {
    @Expose
    @SerializedName(value = "bride")
    private String brideFullName;
    @Expose
    @SerializedName(value = "bridegroom")
    private String bridegroomFullName;
    @Expose
    private AgencyNameTownExportJsonDto agency;
    @Expose
    private Integer invitedGuests;
    @Expose
    private Integer brideGuests;
    @Expose
    private Integer bridegroomGuests;
    @Expose
    private Integer attendingGuests;
    @Expose
    private List<String> guests;

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

    public AgencyNameTownExportJsonDto getAgency() {
        return agency;
    }

    public void setAgency(AgencyNameTownExportJsonDto agency) {
        this.agency = agency;
    }

    public Integer getInvitedGuests() {
        return invitedGuests;
    }

    public void setInvitedGuests(Integer invitedGuests) {
        this.invitedGuests = invitedGuests;
    }

    public Integer getBrideGuests() {
        return brideGuests;
    }

    public void setBrideGuests(Integer brideGuests) {
        this.brideGuests = brideGuests;
    }

    public Integer getBridegroomGuests() {
        return bridegroomGuests;
    }

    public void setBridegroomGuests(Integer bridegroomGuests) {
        this.bridegroomGuests = bridegroomGuests;
    }

    public Integer getAttendingGuests() {
        return attendingGuests;
    }

    public void setAttendingGuests(Integer attendingGuests) {
        this.attendingGuests = attendingGuests;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }
}
