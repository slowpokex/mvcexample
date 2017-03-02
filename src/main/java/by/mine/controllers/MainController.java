package by.mine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by harle on 01.03.2017.
 */

@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mainPageReturn(){
        return "index";
    }
}
