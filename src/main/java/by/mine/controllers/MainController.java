package by.mine.controllers;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by harle on 01.03.2017.
 */

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mainPageReturn(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        userRepository.save(new User());
        return userRepository.findAll(); }
}
