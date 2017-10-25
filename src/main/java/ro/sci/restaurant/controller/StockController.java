package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Ingredients;

//import ro.sci.restaurant.domain.Item;

//
///**
// * Created by cosmin on 9/23/17.
// */

/**
 * This controller is used to add, remove, and retrieve menu items
 */
@Controller
public class StockController extends AbstractController {


    /**
     * Retrieves the thymeleaf page and assigns an ingredients object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String addIngredientsForm(Model model) {
        model.addAttribute("ingredient", new Ingredients());
        return "additem";
    }
    /**
     * Inserts the newly created menu object into the repository after it has been initialised
     * @param ingredient - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String addIngredients(@ModelAttribute Ingredients ingredient) {
        stockService.add(ingredient);
        return "additem";
    }
    /**
     * Retrieves the thymeleaf page and assigns an ingredients object to be initialised in the page
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    // TODO TO BE REVIEWED
    @RequestMapping(value = "/removeitem", method = RequestMethod.GET)
    public String removeIngredientsForm(Model model) {
        model.addAttribute("ingredient", new Ingredients());
        return "removeitem";
    }
    /**
     * Use the newly created ingredient object to compare it to other objects in the employee repository to be removed
     * @param ingredient - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/removeitem", method = RequestMethod.POST)
    public String removeIngredients(@ModelAttribute Ingredients ingredient) {
        stockService.remove(ingredient);
        return "removeitem"; //TODO TO  BE REVIEWED
    }
    /**
     * Retrieves all ingredient objects from the repository and lists them in the form
     * @param model - used to assign the list returned from the repository and insert the into the ingredient variable in the form
     * @return
     */
    @RequestMapping(value = "/getallitems", method = RequestMethod.GET)
    public String getStock(Model model) {
        model.addAttribute("items", stockService.getAll());
        return "getstock";
    }
}

