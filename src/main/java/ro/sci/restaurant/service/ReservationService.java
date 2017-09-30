package ro.sci.restaurant.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.domain.Customer;
import ro.sci.restaurant.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

//import ro.sci.restaurant.domain.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    public Customer findByUid(int id) {
        return reservationRepository.findByUid(id);
    }

    public List<Customer> getAll() {
        List<Customer> customer = new ArrayList<>();
        reservationRepository.findAll()
                .forEach(customer::add);
        return customer;
    }

    public List<Customer> findByName(String name) {
        List<Customer> customer = new ArrayList<>();

        return customer;
    }

//    public Employee findByUid(int uid){
//    };

    //public List<Customer> getByRole() {
    //return null;
    //}

//    public Employee getByUsername(String username) {
//        return employeeRepository.findOne(username);
//    }

    public void update(Customer employee) {


        reservationRepository.save(employee);
    }

    public void add(Customer customer) {
        reservationRepository.save(customer);
    }

    public void delete(int id) {
        reservationRepository.delete(id);
    }
}


