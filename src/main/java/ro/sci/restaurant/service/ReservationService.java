package ro.sci.restaurant.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Reservation;
import ro.sci.restaurant.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

//import ro.sci.restaurant.model.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll()
                .forEach(reservations::add);
        return reservations;
    }

    public void add(Reservation reservation) {
        boolean resExists = false;
        // added verification for date also //
        for (Reservation res : reservationRepository.findAll()) {
            if (res.getPhoneNumber().equals(reservation.getPhoneNumber())
                    && (res.getReservationDate()).equals(reservation.getReservationDate())) {
                //TODO Date not persisted in DB //
                resExists = true;
                System.out.println("You are already booked a reservation");
                break;
            }
            if (res.getSeats() < reservation.getAvailableSeats()) {
                System.out.println("We have only" + res.getSeats() + "available");
            }
        }
        if (!resExists) {
            reservationRepository.save(reservation);
        }
    }

    public void remove(Reservation reservation) {
        for (Reservation res : reservationRepository.findAll()) {
            if (res.getPhoneNumber().equals(reservation.getPhoneNumber())) {
                reservationRepository.delete(res.getUid());
                break;
            }
        }
    }
    public void delete(int id) {
        reservationRepository.delete(id);
    }

}


