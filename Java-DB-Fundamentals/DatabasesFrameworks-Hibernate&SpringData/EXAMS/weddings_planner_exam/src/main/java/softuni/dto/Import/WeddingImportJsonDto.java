package softuni.dto.Import;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class WeddingImportJsonDto {

    @Expose
    @NotNull
    @SerializedName("Bride")
    private String bride;

    @Expose
    @NotNull
    @SerializedName("Bridegroom")
    private String bridegroom;

    @Expose
    @NotNull
    @SerializedName("Date")
    private Date date;

    @Expose
    @NotNull
    @SerializedName("Agency")
    private String agency;

    @Expose
    @SerializedName("Guests")
    private List<GuestImportDto> guests;

    public String getBride() {
        return bride;
    }

    public void setBride(String bride) {
        this.bride = bride;
    }

    public String getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(String bridegroom) {
        this.bridegroom = bridegroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<GuestImportDto> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestImportDto> guests) {
        this.guests = guests;
    }
}
