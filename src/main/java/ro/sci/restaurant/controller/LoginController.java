package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Credentials;

@Controller
public class LoginController extends AbstractController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginForm(Model model) {
        model.addAttribute("credential", new Credentials());
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLogin(@ModelAttribute Credentials credential) {
        for (Credentials cre : credentialService.getAll()) {
            if (cre.getUsername().equals(credential.getUsername()) && cre.getPassword().equals(credential.getPassword())) {
                return "success";
            }
        }
        return "loginForm";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignUpForm() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String getSignUp() {
        return "sucess";
    }

}
