package ro.sci.restaurant.repository;


import org.springframework.data.repository.CrudRepository;
import ro.sci.restaurant.domain.Menu;

//import ro.sci.restaurant.domain.Item;

/**
 * Created by cosmin on 9/25/17.
 */
//@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {

    //Menu findByName(String name);
    Menu findByUid(int id);

    Menu findAllByDishName(String dishName);
    //Menu findAllByIngredients(Item item); //TODO IT WORKS ?

    //TODO
}
