package by.mine.controllers.rest;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import by.mine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @GetMapping("/user")
    public User getUserByName(@RequestParam("login") String login) {
        return userService.getUserByLogin(login);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "create";
    }

}
