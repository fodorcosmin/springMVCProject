//package ro.sci.restaurant.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ro.sci.restaurant.model.Customer;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by cosmin on 9/23/17.
// */
//@Controller
//public class ReservationController extends AbstractController {
//
//    @RequestMapping(value = "/restaurant/makereservations", method = RequestMethod.GET)
//    public String makeReservationForm() {
//        //return "makeReservationForm";
//        return "success";
//    }
//
//    @RequestMapping(value = "/restaurant/makereservations", method = RequestMethod.POST)
//    public String makeReservation(HttpServletRequest request) {
//        String customerFirstName = request.getParameter("first_name");
//        String customerLastName = request.getParameter("last_name");
//        String customerDate = request.getParameter("date");
//        Customer customer = new Customer(customerFirstName, customerLastName);
//        {
//            ;
//            return "reservationAdded";
//        }
//
//    }
//
//    @RequestMapping(value = "/restaurant/removereservation", method = RequestMethod.GET)
//    public String removeReservationForm() {
//        //return "removeReservation";
//        return "success";
//    }
//
//    @RequestMapping(value = "/restaurant/removereservation", method = RequestMethod.POST)
//    public String removeReservation(HttpServletRequest request) {
//        String customerNameAndSurname = request.getParameter("name");
//        String reservationDate = request.getParameter("date");
//        Customer customer = new Customer();
////        reservationService.delete(customer.getUid());
//        customer = null;
//        return "removeReservationSuccess";
//    }
//
//
//}
