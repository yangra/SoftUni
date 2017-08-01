package softuni.store.models.bindingModels.game.edit;


import softuni.store.validations.DoublePrecision;

import java.io.Serializable;

public class EditGameSize implements Serializable {

    @DoublePrecision(positive = true, fraction = 1,message = "Invalid game size")
    private Double size;

    public EditGameSize() {
    }

    public EditGameSize(Double size) {
        this.size = size;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
