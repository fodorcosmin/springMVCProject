package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Employee;
import ro.sci.restaurant.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List getAll() {
     return employeeRepository.findAll();
    }

    public boolean add(Employee employee) {
//        for (Employee emp : employeeRepository.findAll()) {
//            if (emp.getEmail().equals(employee.getEmail()) || emp.getPhoneNumber().equals(employee.getPhoneNumber())) {
//                return false;
//            }
//        }
        employeeRepository.save(employee);
        return true;
    }

    public Employee getByID(int uid) {
        return employeeRepository.findByUid(uid);
    }

    public Employee removeByID(int uid) {
        return employeeRepository.deleteByUid(uid);
    }
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    public void remove(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void removeByEmail(String email) {
        employeeRepository.deleteByEmail(email);
    }

}
