package softuni.store.models.bindingModels.game.edit;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class EditGameTitle implements Serializable{

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 symbols long")
    @Pattern(regexp = "[A-Z]+.+", message = "Title must start with uppercase letter")
    private String title;

    public EditGameTitle() {
    }

    public EditGameTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
