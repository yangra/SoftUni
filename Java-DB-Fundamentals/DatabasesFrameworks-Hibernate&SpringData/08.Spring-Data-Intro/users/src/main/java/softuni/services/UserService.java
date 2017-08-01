package softuni.services;

import softuni.entities.User;

import java.util.Date;
import java.util.List;

public interface UserService<User, Integer> extends ServiceInterface<User, Integer> {
    List<User> getAllUsersByEmailProvider(String provider);

    List<User> getAllUsersWithPictures();

    List<User> getAllUsersInactiveAfter(Date date);

    void remove(User user);
}
