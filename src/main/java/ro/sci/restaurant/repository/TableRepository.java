package ro.sci.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sci.restaurant.domain.Table;

import java.util.List;

/**
 * Created by cosmin on 9/28/17.
 */
public interface TableRepository extends CrudRepository<Table, Integer> {

    Table findByUid(int uid);

    List<Table> findAll();
}
