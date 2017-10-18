package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Customer;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by cosmin on 9/23/17.
 */
@Controller
public class ReservationController extends AbstractController {

    @RequestMapping(value = "/addreservation", method = RequestMethod.GET)
    public String makeReservationForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("date", new Date());
        return "addreservation";
    }

    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    public String makeReservation(@ModelAttribute Customer customer, @ModelAttribute Date date) {
        for (Customer cust : reservationService.getAll()) {
            if (cust.getUid() == customer.getUid()) {
                return "success";
            }
        }
        reservationService.add(customer);
        return "addreservation";
    }

    @RequestMapping(value = "/restaurant/removereservation", method = RequestMethod.GET)
    public String removeReservationForm(Model model) {
        model.addAttribute("", new Customer());
        return "success";
    }

    @RequestMapping(value = "/restaurant/removereservation", method = RequestMethod.POST)
    public String removeReservation(HttpServletRequest request) {
        String customerNameAndSurname = request.getParameter("name");
        String reservationDate = request.getParameter("date");
        Customer customer = new Customer();
//        reservationService.delete(customer.getUid());
        customer = null;
        return "removeReservationSuccess";
    }

    @RequestMapping(value = "/restaurant/getAllReservations", method = RequestMethod.GET)
    public String getAllReservations(Model model) {
        model.addAttribute("customers", reservationService.getAll());
        return "allReservations";
    }

}
