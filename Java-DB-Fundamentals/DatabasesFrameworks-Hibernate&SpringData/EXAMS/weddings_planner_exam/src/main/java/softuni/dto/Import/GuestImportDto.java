package softuni.dto.Import;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Yana on 8/10/2017.
 */
public class GuestImportDto {
    @Expose
    @SerializedName("Name")
    private String guest;
    @Expose
    @SerializedName("RSVP")
    private Boolean attending;
    @Expose
    @SerializedName("Family")
    private String family;

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Boolean getAttending() {
        return attending;
    }

    public void setAttending(Boolean attending) {
        this.attending = attending;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
