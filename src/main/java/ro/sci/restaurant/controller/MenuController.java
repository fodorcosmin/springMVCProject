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
/**
 * This controller is used to add, remove, and retrieve menu items
 */
@Controller
public class MenuController extends AbstractController {

    /**
     * Retrieves the thymeleaf page and assigns a menu object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/addmenuitem", method = RequestMethod.GET)
    public String addMenuForm(Model model) {

        model.addAttribute("menu", new Menu());
        return "addmenuitem";
    }
    /**
     * Inserts the newly created menu object into the repository after it has been initialised
     * @param menu - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/addmenuitem", method = RequestMethod.POST)
    public String addMenu(@ModelAttribute Menu menu) {
        menuService.add(menu);
        return "addmenuitem";
    }

    /**
     * Retrieves the thymeleaf page and assigns a menu object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/removemenuitem", method = RequestMethod.GET)
    public String removeMenuForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "removemenuitem";
    }
    /**
     * Use the newly created menu object to compare it to other objects in the employee repository to be removed
     * @param menu - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/removemenuitem", method = RequestMethod.POST)
    public String removeMenu(@ModelAttribute Menu menu) {
        menuService.removeByDishName(menu.getDishName());
        return "removemenuitem";
    }

    /**
     * Retrieves all employee objects from the repository and lists them in the form
     * @param model - used to assign the list returned from the repository and insert the into the employee variable in the form
     * @return
     */
    @RequestMapping(value = "/getallmenus", method = RequestMethod.GET)
    public String menu(Model model) {
        model.addAttribute("menu", menuService.getAll());
        return "getallmenus";
    }
}