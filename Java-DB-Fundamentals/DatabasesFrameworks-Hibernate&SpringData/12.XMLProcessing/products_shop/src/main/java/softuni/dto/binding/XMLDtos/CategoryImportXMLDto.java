package softuni.dto.binding.XMLDtos;

import softuni.dto.binding.Add.CategoryAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportXMLDto {
    @XmlElement(name = "category")
    private List<CategoryAddDto> categories;

    public CategoryImportXMLDto() {
    }

    public List<CategoryAddDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryAddDto> categories) {
        this.categories = categories;
    }
}
