package ro.sci.restaurant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.domain.Employee;
import ro.sci.restaurant.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee findByUid(int id) {
        return employeeRepository.findByUid(id);
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employees::add);
        return employees;
    }

//    public Employee findByUid(int uid){
//    };

    public List<Employee> getByRole() {
        return null;
    }

//    public Employee getByUsername(String username) {
//        return employeeRepository.findOne(username);
//    }

    public void update(Employee employee) {


        employeeRepository.save(employee);
    }

    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id) {
        employeeRepository.delete(id);
    }
}
