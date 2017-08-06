package softuni.dto.binding.XMLDtos;


import softuni.dto.binding.Add.UserAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportXMLDto {
    @XmlElement(name = "user")
    private List<UserAddDto> userAddDtos;

    public UsersImportXMLDto() {
    }

    public List<UserAddDto> getUserAddDtos() {
        return userAddDtos;
    }

    public void setUserAddDtos(List<UserAddDto> userAddDtos) {
        this.userAddDtos = userAddDtos;
    }
}
