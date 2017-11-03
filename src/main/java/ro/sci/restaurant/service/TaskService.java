package ro.sci.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sci.restaurant.model.Task;
import ro.sci.restaurant.repository.TaskRepository;

import java.util.List;

/**
 * Created by cosmin on 28.10.2017.
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public List getAll() {
        return taskRepository.findAll();
    }

    public void add(Task task) {
        taskRepository.save(task);
    }
}
