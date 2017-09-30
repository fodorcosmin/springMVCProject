package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sci.restaurant.domain.Employee;

import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
@Controller
public class EmployeeController extends AbstractController {

    @RequestMapping(value = "/")
    public String index(Model model) {

        // TODO - fetch users and pass to template
        //List<Employee> employees =employeeRepository.findAll();
        List<Employee> employees = employeeService.getAll();
        //List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "index";
    }


}