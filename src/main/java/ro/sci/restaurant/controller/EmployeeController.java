package ro.sci.restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sci.restaurant.model.Credentials;
import ro.sci.restaurant.model.Employee;


/**
 * Created by Andrei Andrei on 9/25/17.
 * This controller is used to add, remove, and retrieve employee and credentials assigned to said employee
 * All said operations can only be carried out by an employee with administrator privileges
 */
@Controller
public class EmployeeController extends AbstractController {

    private String name = "";
    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Retrieves the thymeleaf page and assigns a credential object to be initialised in the page
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
     * @param credentials - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/addEmployeeCredentials", method = RequestMethod.POST)
    public String addCredential(@ModelAttribute Credentials credentials, Model model) {
        if(credentialService.add(credentials))
        {
            model.addAttribute("empName", "Added employee " + credentials.getUsername());
            return "credentials";
        }
        model.addAttribute("empName", "Employee " + credentials.getUsername() + " already exists");
        return "addEmployee";
    }


    /**
     * Retrieves the thymeleaf page and assigns an employee object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    /**
     * Inserts the newly initialised employee object into the repository after it has been initialised
     * @param employee - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        name = employee.getFirstName();
        if(employeeService.add(employee))
        {
            model.addAttribute("empName", "Added employee " + name);
            return "redirect:/addEmployeeCredentials";
        }
        model.addAttribute("empName", "Employee " + employee.getFirstName() + " already exists");
        return "addEmployee";
    }


    /**
     * Retrieves the thymeleaf page and assigns an employee object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/removeEmployee", method = RequestMethod.GET)
    public String removeEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "delEmployee";
    }
    /**
     * Use the newly created employee object to compare it to other objects in the employee repository to be removed
     * @param employee - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/removeEmployee", method = RequestMethod.POST)
    public String remEmployee(@ModelAttribute Employee employee) {
        employeeService.removeByEmail(employee.getEmail());
        return "delEmployee";
    }


    /**
     * Retrieves all employee objects from the repository and lists them in the form
     * @param model - used to assign the list returned from the repository and insert the into the employee variable in the form
     * @return
     */
    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public String getAllForm(Model model) {
        model.addAttribute("employee", employeeService.getAll());
        return "employees";
    }
    /**
     * Retrieves all credential objects from the repository and lists them in the form
     * @param model - used to assign the list returned from the repository and insert the into the credential variable in the form
     * @return
     */
    @RequestMapping(value = "/getallcredentials", method = RequestMethod.GET)
    public String getLoginForm(Model model) {

        model.addAttribute("credential", credentialService.getAll());
        return "allcredentials";
    }


    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployeeForm(Model model) {
        model.addAttribute("idGet", 2);
        model.addAttribute("employee", new Employee());
        return "updateEmployee";

    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(Model model, @ModelAttribute Employee employee, @RequestParam(name = "idGet", required = false) Integer idGet, @RequestParam(value = "action", required = false) String action) {
        if (action.equals("get")) {
            model.addAttribute("employee", employeeService.getByUid(idGet));
        }
        if (action.equals("save")) {
            employeeService.update(employee);
        }
        return "updateEmployee";
    }


    @RequestMapping(value = "/updateCredentials", method = RequestMethod.GET)
    public String updateCredentialsForm(Model model, @PathVariable Integer id) {
        model.addAttribute("idGet", 2);
        model.addAttribute("credentials", new Credentials());
        return "updateCredentials";
    }

    @RequestMapping(value = "/updateCredentials", method = RequestMethod.POST)
    public String updateCredentials(Model model, @ModelAttribute Credentials credentials, @RequestParam(name = "idGet", required = false) Integer idGet, @RequestParam(value = "action", required = false) String action) {
        if (action.equals("get")) {
            model.addAttribute("credentials", employeeService.getByUid(idGet));
        }
        if (action.equals("save")) {
            credentialService.update(credentials);
        }
        return "updateCredentials";
    }


}

