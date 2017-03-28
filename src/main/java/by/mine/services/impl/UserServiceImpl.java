package by.mine.services.impl;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import by.mine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public List<User> getUsersByLogin(String login) {
        return userRepository.findByLoginLike(login);
    }
    public User getUsersByID(int id) {
        return userRepository.findOne(id);
    }
}
