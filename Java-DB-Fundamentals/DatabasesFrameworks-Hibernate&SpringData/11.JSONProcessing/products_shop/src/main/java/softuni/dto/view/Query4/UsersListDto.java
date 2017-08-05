package softuni.dto.view.Query4;


import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersListDto {
    @Expose
    private int usersCount;
    @Expose
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
