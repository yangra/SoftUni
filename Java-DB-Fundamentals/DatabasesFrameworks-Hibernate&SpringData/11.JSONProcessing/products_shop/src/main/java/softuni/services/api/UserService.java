package softuni.services.api;


import softuni.dto.binding.UserDto;
import softuni.dto.binding.Add.UserAddDto;
import softuni.dto.view.Query2.UserSoldProductsDto;
import softuni.dto.view.Query4.UsersListDto;

import java.util.List;

public interface UserService {
    void save(UserAddDto userAddDto);

    List<UserDto> findAll();

    List<UserSoldProductsDto> getUserSoldProducts();

    UsersListDto getUsersBySoldProductsCount();
}
