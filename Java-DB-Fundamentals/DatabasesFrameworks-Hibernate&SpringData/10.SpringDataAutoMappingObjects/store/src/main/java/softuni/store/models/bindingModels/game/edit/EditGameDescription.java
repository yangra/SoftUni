package softuni.store.models.bindingModels.game.edit;


import javax.validation.constraints.Size;
import java.io.Serializable;

public class EditGameDescription implements Serializable {

    @Size(min = 20)
    private String description;

    public EditGameDescription() {
    }

    public EditGameDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
