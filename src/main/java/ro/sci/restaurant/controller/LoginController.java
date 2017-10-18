package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Credentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends AbstractController {


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String getLoginForm(Model model) {
//
//        model.addAttribute("credentials", new Credentials());
//        return "loginForm";
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(HttpServletRequest request, Model model) {
//
//        // Implementing employee login
//
//        // get parameters from request
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//
//        // get user by their username
//
//        if  (username.equals("") && password.equals("")) {
//            model.addAttribute("error", "Username and Password are required.");
//            model.addAttribute("username", username);
//            model.addAttribute("password", password);
//            return "login";
//    }
//
//        String verify=request.getParameter("verify");
//
//
//        //validate parameters (username, password, verify)
//        if (!password.equals(verify)) {
//            model.addAttribute("verify_error", "Passwords do not match.");
//            model.addAttribute("username", username);
//            return "registeremployee";
//        } else {
//
//            if (!Employee.isValidUsername(username)) {
//                model.addAttribute("username_error", "Username is not valid.");
//                return "registeremployee";
//
//            } else if (!Employee.isValidPassword(password)){
//                model.addAttribute("password_error", "Password is not valid.");
//                model.addAttribute("username", username);
//                return "registeremployee";
//
//            }
//        }
//
//        //if they validate, create a new employee, and put them in the session
//        Employee u= employeeDao.findByUsername(username);
//        if (u == null) {
//            Employee newUser= new Employee(username, password);
//            employeeDao.save(newUser);
//            HttpSession thisSession = request.getSession();
//            this.setUserInSession(thisSession, newUser);
//
//            return "redirect:/customerlookup";
//        } else{
//            model.addAttribute("username_error", "That username already exists!");
//            return "registeremployee";
//        }
//
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        // model.addAttribute("credentials", new Credentials());
        return "loginTest";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String role=request.getParameter("role");


        // Credentials u = new Credentials();
        // u.setPassword(password);
        // u.setUsername(username);
        // u.setRole(role);
        Credentials u = credentialService.getByUsername(username);
        if (u == null) {
            return "success";
        }
        if (u.getPassword().equals(password) && u.getUsername().equals(username)) {
            HttpSession thisSession = request.getSession(true);
            this.setUserInSession(thisSession, u);
        }
        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}

