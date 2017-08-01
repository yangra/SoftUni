package softuni.store.models.bindingModels.game.edit;


import javax.validation.constraints.Size;
import java.io.Serializable;

public class EditGameTrailer implements Serializable {
    @Size(min = 11, max = 11, message = "Trailer must be 11 symbols.")
    private String trailer;

    public EditGameTrailer() {
    }

    public EditGameTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
