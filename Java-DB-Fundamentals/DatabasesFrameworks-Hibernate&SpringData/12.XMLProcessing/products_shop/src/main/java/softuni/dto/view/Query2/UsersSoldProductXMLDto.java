package softuni.dto.view.Query2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSoldProductXMLDto {
    @XmlElement(name = "user")
    private List<UserSoldProductsDto> userSoldProductsDtos;

    public UsersSoldProductXMLDto() {
    }

    public List<UserSoldProductsDto> getUserSoldProductsDtos() {
        return userSoldProductsDtos;
    }

    public void setUserSoldProductsDtos(List<UserSoldProductsDto> userSoldProductsDtos) {
        this.userSoldProductsDtos = userSoldProductsDtos;
    }
}
