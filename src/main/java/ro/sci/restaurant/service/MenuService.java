package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Menu;
import ro.sci.restaurant.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu findByUid(int id) {
        return menuRepository.findByUid(id);
    }

    // public Menu findByName(String name)
    // {
    //   return menuRepository.findByName(name);
    // }
    public List<Menu> getAll() {
        List<Menu> menu = new ArrayList<>();
        menuRepository.findAll()
                .forEach(menu::add);
        return menu;
    }

//    public Employee findByUid(int uid){
//    };

    public List<Menu> getByRole() {
        return null;
    }

//    public Employee getByUsername(String username) {
//        return employeeRepository.findOne(username);
//    }

    public void update(Menu menu) {


        menuRepository.save(menu);
    }

    public void add(Menu menu) {
        menuRepository.save(menu);
    }

    public void delete(int id) {
        menuRepository.delete(id);
    }
}
