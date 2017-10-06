package ro.sci.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sci.restaurant.model.Employee;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findEmployeeById(int uid);

    List<Employee> findAll();
}
