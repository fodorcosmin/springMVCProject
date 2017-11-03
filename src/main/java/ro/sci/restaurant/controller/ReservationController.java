package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Reservation;

/**
 * Created by cosmin on 9/23/17.
 */
@Controller
public class ReservationController extends AbstractController {

    @RequestMapping(value = "/addreservation", method = RequestMethod.GET)
    public String makeReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "addreservation";
    }

    @RequestMapping(value = "/addreservation", method = RequestMethod.POST)
    public String makeReservation(Reservation reservation) {
        reservationService.add(reservation);
        return "redirect:/home";
    }

    @RequestMapping(value = "/removereservation", method = RequestMethod.GET)
    public String removeReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservations";
    }

    @RequestMapping(value = "/removereservation", method = RequestMethod.POST)
    public String removeReservation(Reservation reservation) {
        reservationService.remove(reservation);
        return "reservations";
    }

    @RequestMapping(value = "/getReservations", method = RequestMethod.GET)
    public String getAllReservations(Model model) {
        model.addAttribute("reservation", reservationService.getAll());
        return "reservations";
    }

}
