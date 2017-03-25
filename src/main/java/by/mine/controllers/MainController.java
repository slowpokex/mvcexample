package by.mine.controllers;

import by.mine.beans.User;
import by.mine.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by harle on 01.03.2017.
 */

@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
}
