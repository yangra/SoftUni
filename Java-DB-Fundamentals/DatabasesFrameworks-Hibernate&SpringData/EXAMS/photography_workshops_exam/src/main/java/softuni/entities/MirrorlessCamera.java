package softuni.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "mirrorless")
public class MirrorlessCamera extends Camera {
    private String maxVideoResolution;
    private Integer maxFrameRate;

    public MirrorlessCamera() {
    }

    @Override
    public String type() {
        return "Mirrorless";
    }

    @Column(name="max_video_resolution")
    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    @Column(name = "max_frame_rate")
    public Integer getMaxFrameRate() {
        return maxFrameRate;
    }

    public void setMaxFrameRate(Integer maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}
