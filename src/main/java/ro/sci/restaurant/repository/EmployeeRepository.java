package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.restaurant.domain.Employee;

import java.util.List;


/**
 * Created by cosmin on 9/25/17.
 */
@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findByUid(int uid);

    List<Employee> findAll();

}
