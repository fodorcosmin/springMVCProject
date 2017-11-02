package ro.sci.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sci.restaurant.model.Task;

import java.util.List;

/**
 * Created by cosmin on 28.10.2017.
 */
@Repository

public interface TaskRepository extends CrudRepository<Task, Integer> {
    List<Task> findAll();
}
