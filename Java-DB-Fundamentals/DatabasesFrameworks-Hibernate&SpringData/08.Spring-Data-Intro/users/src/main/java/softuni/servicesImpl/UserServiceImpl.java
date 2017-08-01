package softuni.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.entities.User;
import softuni.repositories.UserRepository;
import softuni.services.UserService;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService<User,Integer> {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public List<User> getAllUsersByEmailProvider(String provider) {
        return this.userRepository.findByEmailEndingWith(provider);
    }

    @Override
    public List<User> getAllUsersWithPictures() {
        return this.userRepository.findByProfilePicturePathNotNull();
    }

    @Override
    public List<User> getAllUsersInactiveAfter(Date date) {
        return this.userRepository.findByLastTimeLoggedInBefore(date);
    }

}
