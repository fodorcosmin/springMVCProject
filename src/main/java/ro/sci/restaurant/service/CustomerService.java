package ro.sci.restaurant.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Customer;
import ro.sci.restaurant.repository.CustomerRepository;

import java.util.List;

//import ro.sci.restaurant.model.Reservation;

///**
// * Created by cosmin on 9/25/17.
// */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List getAll() {
        return customerRepository.findAll();
    }

    public void add(Customer customer) {
        boolean resExists = false;
        // added verification for date also //
        for (Customer cust : customerRepository.findAll()) {
            if (cust.getPhoneNumber().equals(customer.getPhoneNumber())
                    && (cust.getReservationDate()).equals(customer.getReservationDate())) {
                resExists = true;
                break;
            }
                customerRepository.save(customer);
            }
        }

    public void remove(Customer customer) {
        for (Customer cust : customerRepository.findAll()) {
            if (cust.getPhoneNumber().equals(customer.getPhoneNumber())) {
                customerRepository.delete(cust.getUid());
                break;
            }
        }
    }

    public void delete(int id) {
        customerRepository.delete(id);
    }

}


