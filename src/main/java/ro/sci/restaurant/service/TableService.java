package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.domain.Table;
import ro.sci.restaurant.repository.TableRepository;

import java.util.List;

/**
 * Created by cosmin on 9/28/17.
 */
@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;


    public List<Table> getAll() {
        return tableRepository.findAll();
    }
}
