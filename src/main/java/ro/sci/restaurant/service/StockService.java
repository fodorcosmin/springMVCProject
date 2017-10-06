package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Ingredients;
import ro.sci.restaurant.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;

//import ro.sci.restaurant.domain.Stock;

/**
 * Created by cosmin on 9/25/17.
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Ingredients findByUid(int id) {
        return stockRepository.findByUid(id);
    }

    public List<Ingredients> getAll() {
        List<Ingredients> ingredient = new ArrayList<>();
        stockRepository.findAll()
                .forEach(ingredient::add);
        return ingredient;
    }

//    public Employee findByUid(int uid){
//    };

    public List<Ingredients> getByRole() {
        return null;
    }

//    public Employee getByUsername(String username) {
//        return employeeRepository.findOne(username);
//    }

    public void update(Ingredients ingredient) {


        stockRepository.save(ingredient);
    }

    public void add(Ingredients ingredient) {
        stockRepository.save(ingredient);
    }

    public void delete(int id) {
        stockRepository.delete(id);
    }

}
