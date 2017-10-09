package softuni.dto.Export;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographerSameCameraXmlExportDto {
    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;
    @XmlTransient
    private String primaryCameraMake;
    @XmlTransient
    private String primaryCameraModel;

    @XmlElementWrapper(name = "lenses")
    @XmlElement(name = "lens")
    private Set<LensExportDto> lenses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryCameraMake() {
        return primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public String getPrimaryCameraModel() {
        return primaryCameraModel;
    }

    public void setPrimaryCameraModel(String primaryCameraModel) {
        this.primaryCameraModel = primaryCameraModel;
    }

    public Set<LensExportDto> getLenses() {
        return lenses;
    }

    public void setLenses(Set<LensExportDto> lenses) {
        this.lenses = lenses;
    }

    @XmlAttribute(name = "name")
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @XmlAttribute(name = "primary-camera")
    public String getPrimaryCamera() {
        return primaryCameraMake + " " + primaryCameraModel;
    }
}
