package by.mine.controllers.rest;

import by.mine.beans.Comment;
import by.mine.beans.User;
import by.mine.dao.CommentRepository;
import by.mine.dao.UserRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Comment> getCommentsByUser(@RequestParam("login") String username) {
        return commentRepository.findByUser(userRepository.findByLogin(username));
    }

}
