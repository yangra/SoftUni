package softuni.store.models.bindingModels.game.edit;


import java.io.Serializable;
import java.util.Date;

public class EditGameReleaseDate implements Serializable{

    private Date releaseDate;

    public EditGameReleaseDate() {
    }

    public EditGameReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
