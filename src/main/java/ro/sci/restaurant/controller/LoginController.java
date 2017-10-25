package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Credentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

///**
// * Created by Andrei on 9/25/17.
// * This controller is used to authenticate and authorize users based on a name and password combination
// */
@Controller
public class LoginController extends AbstractController {

    /**
     * Retrieves the login page
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "loginTest";
    }

    /**
     * Used to retrieve the username and password inserted in the form and search the repository for a user with the
     * matching username and password.
     * @param request - the request servlet is used to retrieve the username and password from the form.
     *                - retrieve current session and set the user ID as an attribute to be later used
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Credentials u = credentialService.getByUsername(username);
        if (u == null) {
            return "loginTest";
        }
        if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
            HttpSession thisSession = request.getSession(true);
            this.setUserInSession(thisSession, u);
        }
        return "redirect:/";
    }

    /**
     * Used to logout from the current user
     * @param request - retrieve the current session and invalidate it
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "home";
    }
}

