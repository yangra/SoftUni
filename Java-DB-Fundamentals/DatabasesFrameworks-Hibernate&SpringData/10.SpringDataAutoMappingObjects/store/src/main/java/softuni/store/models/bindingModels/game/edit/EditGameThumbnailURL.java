package softuni.store.models.bindingModels.game.edit;


import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class EditGameThumbnailURL implements Serializable{

    @Pattern(regexp = "((http:\\/\\/)|(https:\\/\\/)).+", message = "Invalid URL")
    private String thumbnailURL;

    public EditGameThumbnailURL() {
    }

    public EditGameThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
