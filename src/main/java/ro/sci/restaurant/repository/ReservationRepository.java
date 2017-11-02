package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.restaurant.model.Reservation;

//import ro.sci.restaurant.model.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {



}
