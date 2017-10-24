package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Menu;

/**
 * Created by cosmin on 9/23/17.
 */
@Controller
public class MenuController extends AbstractController {

    @RequestMapping(value = "/addmenuitem", method = RequestMethod.GET)
    public String addMenuForm(Model model) {

        model.addAttribute("menu", new Menu());
        return "addmenuitem";
    }

    @RequestMapping(value = "/addmenuitem", method = RequestMethod.POST)
    public String addMenu(@ModelAttribute Menu menu) {
        menuService.add(menu);
        return "addmenuitem";
    }

    @RequestMapping(value = "/removemenuitem", method = RequestMethod.GET)
    public String removeMenuForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "removemenuitem";
    }

    @RequestMapping(value = "/removemenuitem", method = RequestMethod.POST)
    public String removeMenu(@ModelAttribute Menu menu) {
        menuService.removeByDishName(menu.getDishName());
        return "removemenuitem";
    }

    @RequestMapping(value = "/getallmenus", method = RequestMethod.GET)
    public String menu(Model model) {
        model.addAttribute("menu", menuService.getAll());
        return "getallmenus";
    }
}