package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Customer;

/**
 * Created by cosmin on 9/23/17.
 */
@Controller
public class CustomerController extends AbstractController {

    @RequestMapping(value = "/addreservation", method = RequestMethod.GET)
    public String makeReservationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addreservation";
    }

    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    public String makeReservation(Customer customer) {
        customerService.add(customer);
        return "employees";
    }

    @RequestMapping(value = "/removereservation", method = RequestMethod.GET)
    public String removeReservationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "reservations";
    }

    @RequestMapping(value = "/removereservation", method = RequestMethod.POST)
    public String removeReservation(Customer customer) {
        customerService.remove(customer);
        return "reservations";
    }

    @RequestMapping(value = "/getReservations", method = RequestMethod.GET)
    public String getAllReservations(Model model) {
        model.addAttribute("customer", customerService.getAll());
        return "reservations";
    }

}
