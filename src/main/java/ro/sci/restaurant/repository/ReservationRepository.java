package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.restaurant.domain.Customer;
import ro.sci.restaurant.domain.Reservation;

import java.util.List;

//import ro.sci.restaurant.domain.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Repository
public interface ReservationRepository extends CrudRepository<Customer, Integer> {

    Customer findByUid(int id);

    List<Customer> findByName(String fullname); //todo ??

    List<Customer> findAll();

    Reservation checkTable(boolean isAvailable);
    //List<Reservation> findAllByReservationDate(Date date);
}
