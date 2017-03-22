package by.mine.dao;

import by.mine.beans.Comment;
import by.mine.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByMessageLike(String message);
    List<Comment> findByUser(User user);
}
