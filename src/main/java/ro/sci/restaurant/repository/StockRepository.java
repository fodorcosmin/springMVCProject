package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.restaurant.model.Ingredients;

import java.util.List;

//import ro.sci.restaurant.domain.Item;

/**
 * Created by cosmin on 9/25/17.
 */
@Repository
@Transactional
public interface StockRepository extends CrudRepository<Ingredients, Integer> {

    Ingredients findByUid(int id);

    List<Ingredients> findAllByItem(String item);
    //List <Ingredients> findAllByItem(Item item);
    //TODO

}
