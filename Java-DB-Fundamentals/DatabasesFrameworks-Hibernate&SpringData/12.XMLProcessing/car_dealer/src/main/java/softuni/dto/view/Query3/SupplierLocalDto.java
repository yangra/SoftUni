package softuni.dto.view.Query3;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierLocalDto {
    @Expose
    @SerializedName(value = "Id")
    @XmlAttribute
    private Long id;
    @Expose
    @SerializedName(value = "Name")
    @XmlAttribute
    private String name;
    @Expose
    @XmlAttribute(name="parts-count")
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
