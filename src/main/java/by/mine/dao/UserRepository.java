package by.mine.dao;

import by.mine.beans.Comment;
import by.mine.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
    List<User> findByLoginLike(String login);
}
