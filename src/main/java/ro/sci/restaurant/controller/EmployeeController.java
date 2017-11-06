package ro.sci.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sci.restaurant.model.Credentials;
import ro.sci.restaurant.model.Employee;

// thymeleaf is a pain in the ass //
/**
 * This controller is used to add, remove, and retrieve employee and credentials assigned to said employee
 * All said operations can only be carried out by an employee with administrator privileges
 */
@Controller
public class EmployeeController extends AbstractController {

//
//    @InitBinder("employee")
//    public void bindingPreparation(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class,"hireDate",new CustomDateEditor(dateFormat,true));
//    }
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Retrieves the thymeleaf page and assigns a credential object to be initialised in the page
     *
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/addEmployeeCredentials", method = RequestMethod.GET)
    public String credentialForm(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "credentials";
    }

    /**
     * Inserts the newly created credential object into the repository after it has been initialised
     *
     * @param credentials - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/addEmployeeCredentials", method = RequestMethod.POST)
    public String addCredential(@ModelAttribute Credentials credentials, Model model) {
        if (credentialService.add(credentials)) {
            model.addAttribute("empName", "Added employee " + credentials.getUsername());
            return "credentials";
        }
        model.addAttribute("empName", "Employee " + credentials.getUsername() + " already exists");
        return "addEmployee";
    } //TODO TO BE REVIEWED



    /**
     * Retrieves the thymeleaf page and assigns an employee object to be initialised in the page
     *
     * @param uid - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/delEmp/{uid}", method = RequestMethod.GET)
    public String removeEmployee(@RequestParam Integer uid) {
        employeeService.removeByID(uid);
        return "redirect:/getEmployees";
    }

    /**
     * Retrieves the thymeleaf page and assigns an employee object to be initialised in the page
     *
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/addEmp", method = RequestMethod.GET)
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmp";
    }

    /**
     * Inserts the newly initialised employee object into the repository after it has been initialised
     *
     * @param employee - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        if (employeeService.add(employee)) {
            model.addAttribute("employee", employee);
            return "employees"; //TODO TO BE REVIEWED If binding result is necessary
        }
        model.addAttribute("employee", "Employee " + employee.getFirstName() + employee.getEmail() + " already exists");
        return "Failed!";
    }


    @RequestMapping(value = "/updateEmp/{uid}", method = RequestMethod.POST)
    public String edit(@PathVariable int uid,Model model) {
        model.addAttribute("employee", employeeService.getByID(uid));
        return "employees";
    }


    /**
     * Retrieves all employee objects from the repository and lists them in the form
     *
     * @param model - used to assign the list returned from the repository and insert the into the employee variable in the form
     * @return
     */
    @RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public String getAllForm(Model model) {
        model.addAttribute("employee", employeeService.getAll());
        return "employees";
    }

    /**
     * Retrieves all credential objects from the repository and lists them in the form
     *
     * @param model - used to assign the list returned from the repository and insert the into the credential variable in the form
     * @return
     */
    @RequestMapping(value = "/getCredentials", method = RequestMethod.GET)
    public String getLoginForm(Model model) {
        model.addAttribute("credentials", credentialService.getAll());
        return "credentials";
    }
}

