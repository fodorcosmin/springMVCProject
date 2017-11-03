package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Pages returned after login based on the user role
 */
@Controller
public class HomeController extends AbstractController {


    @RequestMapping(name = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "admin";
    }

    @RequestMapping(value = "/waiter", method = RequestMethod.GET)
    public String waiterPage() {
        return "waiter";
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String managePage() {
        return "manager";
    }

}
