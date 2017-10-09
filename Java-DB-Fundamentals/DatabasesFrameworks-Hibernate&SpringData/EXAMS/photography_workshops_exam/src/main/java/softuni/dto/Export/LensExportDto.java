package softuni.dto.Export;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class LensExportDto {
    @XmlTransient
    private String make;
    @XmlTransient
    private Integer focalLength;
    @XmlTransient
    private Double maxAperture;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }
    @XmlValue
    public String getLensInfo() {
        return make+" "+focalLength+" "+ maxAperture;
    }
}
