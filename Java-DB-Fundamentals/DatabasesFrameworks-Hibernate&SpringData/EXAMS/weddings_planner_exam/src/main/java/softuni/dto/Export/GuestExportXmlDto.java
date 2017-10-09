package softuni.dto.Export;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class GuestExportXmlDto {
    @XmlValue
    private String guestFullName;
    @XmlAttribute(name="family")
    private String familyFamily;

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getFamilyFamily() {
        return familyFamily;
    }

    public void setFamilyFamily(String familyFamily) {
        this.familyFamily = familyFamily;
    }
}
