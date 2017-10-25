package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Pages returned after login based on the user role
 */
@Controller
public class HomeController extends AbstractController{


    @RequestMapping(name = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "home";
    }

    @RequestMapping(value = "/adminhome", method = RequestMethod.GET)
    public String adminPage() { return "adminhome";
    }

    @RequestMapping(value = "/waiterhome", method = RequestMethod.GET)
    public String waiterPage() {
        return "waiterhome";
    }

    @RequestMapping(value = "/stockhome", method = RequestMethod.GET)
    public String stockForm() {
        return "stockhome";
    }
}
