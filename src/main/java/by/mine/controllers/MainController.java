package by.mine.controllers;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harle on 01.03.2017.
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
