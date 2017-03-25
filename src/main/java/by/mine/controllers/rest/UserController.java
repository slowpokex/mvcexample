package by.mine.controllers.rest;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import by.mine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUserByName(@RequestParam("login") String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "create";
    }

}
