package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.restaurant.model.Customer;

import java.util.List;

//import ro.sci.restaurant.model.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findAll();

    Customer findByUid(int uid);
    Customer findByEmail(String email);

}
