package softuni.dto.view.Query3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesViewXMLDto {
    @XmlElement(name = "category")
    private List<CategoryViewDto> categoryViewDtos;

    public CategoriesViewXMLDto() {
    }

    public List<CategoryViewDto> getCategoryViewDtos() {
        return categoryViewDtos;
    }

    public void setCategoryViewDtos(List<CategoryViewDto> categoryViewDtos) {
        this.categoryViewDtos = categoryViewDtos;
    }
}
