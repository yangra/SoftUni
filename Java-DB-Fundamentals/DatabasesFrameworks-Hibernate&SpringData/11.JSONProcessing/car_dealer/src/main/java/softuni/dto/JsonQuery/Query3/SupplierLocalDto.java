package softuni.dto.JsonQuery.Query3;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupplierLocalDto {
    @Expose
    @SerializedName(value = "Id")
    private Long id;
    @Expose
    @SerializedName(value = "Name")
    private String name;
    @Expose
    private Integer partsCount;

    public SupplierLocalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
