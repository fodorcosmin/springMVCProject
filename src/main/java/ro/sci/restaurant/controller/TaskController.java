package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cosmin on 28.10.2017.
 */

@Controller
public class TaskController extends AbstractController {

//    @RequestMapping(value="/addTask",method = RequestMethod.POST)
//    public String addTask(Task task) {
//        taskService.add(task);
//        return "/tasks";
//    }


    @RequestMapping(value = "/getAllTasks", method = RequestMethod.GET)
    public String getAllTasks(Model model) {
        model.addAttribute("task", taskService.getAll());
        return "/tasks";
    }
}