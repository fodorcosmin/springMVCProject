package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Employee;

@Controller
public class EmployeeController extends AbstractController {

    /*
    @RequestMapping(value = "/profile/${id}", method = RequestMethod.GET)
    public String getViewProfile(@PathVariable("id")int id, Model model)
    {
        return "success";
    }
*/
    @RequestMapping(value = "/profile/yourprofile", method = RequestMethod.GET)
    public String getProfileForm(Model model) {
        model.addAttribute("employeename", new Employee());
        return "addEmployee";
    }

    @RequestMapping(value = "/profile/yourprofile", method = RequestMethod.POST)
    public String getProfile(@ModelAttribute Employee employeename) {
        employeeService.add(employeename);
        return "success";
    }

    @RequestMapping(value = "/profile/getAll", method = RequestMethod.GET)
    public String getAllForm(Model model) {
        model.addAttribute("employeename", employeeService.getAll());
        return "employees";
    }
}
