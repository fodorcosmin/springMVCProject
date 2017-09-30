/*
package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.domain.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cosmin on 9/25/17.
 */
/*
@Controller
public class LoginController extends AbstractController {

    //TODO - nu am sters nimic in afara de clasele din model
    //-toate liniile de cod sunt la locul lor si comentate
    //-- trebuiesc doar inlocuite

    @RequestMapping(value = "/registeremployee", method = RequestMethod.GET)
    public String signupForm() {
        return "registeremployee";
    }

    @RequestMapping(value = "/registeremployee", method = RequestMethod.POST)
    public String signup(HttpServletRequest request, Model model) {

        // Implementing signup for employee
        //get parameters from request
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String type=request.getParameter("type");//////ADMIN STOCKMANAGER WAITER ETC

        String verify=request.getParameter("verify");


        //TODO - implement  - implement verification for employee username and password

        //validate parameters (username, password, verify)
        if (!password.equals(verify)) {
            model.addAttribute("verify_error", "Passwords do not match.");
            model.addAttribute("username", username);
            return "registeremployee";
        }

		else {
					employee.isValidUserName
			if (!Employee.confirmUserName(username)) {
				model.addAttribute("username_error", "Username is not valid.");
				return "registeremployee";

			} else if (!Employee.isValidPassword(password)){
				model.addAttribute("password_error", "Password is not valid.");
				model.addAttribute("username", username);
				return "registeremployee";

			}
		}

        //if they validate, create a new employee, and put them in the session
        //Employee u= employeeDao.findByUsername(username);////////////////////////

        Employee employee = employeeService.getByUsername(username);
        if (employee == null) {
            Employee newUser= new Employee(username, password);
            employeeService.add(newUser);;
            HttpSession thisSession = request.getSession();
            this.setUserInSession(thisSession, newUser);

            return "redirect:/customerlookup";
        } else{
            model.addAttribute("username_error", "That username already exists!");
            return "registeremployee";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        // Implementing employee login

        // get parameters from request
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        // get user by their username

        if  (username.equals("") && password.equals("")) {
            model.addAttribute("error", "Username and Password are required.");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "login";
        }
        if (username.equals("")) {

            model.addAttribute("error", "Username is required.");
            return "login";
        }
        if (password.equals("")) {
            model.addAttribute("error", "Password is required.");
            model.addAttribute("username", username);
            return "login";
        }

        //Employee u= employeeDao.findByUsername(username);/////////////////////////////
        Employee u = employeeService.getByUsername(username);
        if (u == null) {
            model.addAttribute("error", "Login failed. Username/Password does not exist.");
            model.addAttribute("username", username);
            return "login";
        }
        //System.out.println(Employee.hashPassword(password)+ " " + u.getPwHash());
        //if (u.isMatchingPassword(password))
        if(u.confirmPassWord(password))
        {
            HttpSession thisSession = request.getSession();
            this.setUserInSession(thisSession, u);
            //	thisSession.setAttribute("user", u);
        } else {
            model.addAttribute("error", "Login failed. Username/Password does not exist.");
            model.addAttribute("username", username);
            return "login";
        }

        // log them in, if so (i.e., setting the employee in the session) might create helper method if need to - not


        return "redirect:/customerlookup";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }
}
*/