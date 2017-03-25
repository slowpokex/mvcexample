package by.mine.services;

import by.mine.beans.User;

import java.util.List;

/**
 * Created by harle on 22.03.2017.
 */
public interface UserService {
    User saveUser(User user);
    void deleteUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
    User getUserByLogin(String login);
    List<User> getUsersByLogin(String login);
    User getUsersByID(int id);
}
