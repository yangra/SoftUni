package softuni.dto.Import;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

/**
 * Created by Yana on 8/13/2017.
 */
public class TownImportJsonDto {
    @NotNull
    @Expose
    private String name;
    @NotNull
    @Expose
    private Long population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
