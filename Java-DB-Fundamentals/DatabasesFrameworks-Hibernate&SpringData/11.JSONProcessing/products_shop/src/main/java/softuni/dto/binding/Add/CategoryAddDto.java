package softuni.dto.binding.Add;


import com.google.gson.annotations.Expose;

public class CategoryAddDto {
    @Expose
    private String name;

    public CategoryAddDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
