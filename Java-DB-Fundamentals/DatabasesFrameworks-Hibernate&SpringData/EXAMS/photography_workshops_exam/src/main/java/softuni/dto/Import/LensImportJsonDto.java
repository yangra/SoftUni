package softuni.dto.Import;


import com.google.gson.annotations.Expose;

public class LensImportJsonDto {
    @Expose
    private String make;
    @Expose
    private Integer focalLength;
    @Expose
    private Double maxAperture;
    @Expose
    private String compatibleWith;

    public LensImportJsonDto() {
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

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
