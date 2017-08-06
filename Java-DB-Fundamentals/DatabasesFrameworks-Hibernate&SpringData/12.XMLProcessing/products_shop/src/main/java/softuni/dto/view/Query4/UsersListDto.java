package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersListDto {
    @Expose
    @XmlAttribute(name = "count")
    private int usersCount;
    @Expose
    @XmlElement(name="user")
    private List<UsersProductsDto> users;

    public UsersListDto() {
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UsersProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersProductsDto> users) {
        this.users = users;
    }
}
