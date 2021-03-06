package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.model.Stock;

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
     *
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String addIngredientsForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "stock";
    }

    /**
     * Inserts the newly created menu object into the repository after it has been initialised
     *
     * @param stock - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String addIngredients(@ModelAttribute Stock stock) {
        stockService.add(stock);
        return "stock";
    }

    /**
     * Retrieves the thymeleaf page and assigns an ingredients object to be initialised in the page
     *
     * @param model - adds the variable to the thymeleaf through addAttribute
     * @return
     */
    // TODO TO BE REVIEWED
    @RequestMapping(value = "/removeitem", method = RequestMethod.GET)
    public String removeIngredientsForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "stock";
    }

    /**
     * Use the newly created ingredient object to compare it to other objects in the employee repository to be removed
     *
     * @param stock - the object initialised from the page with the @ModelAttribute
     * @return
     */
    @RequestMapping(value = "/removeitem", method = RequestMethod.POST)
    public String removeIngredients(@ModelAttribute Stock stock) {
        stockService.remove(stock);
        return "stock"; //TODO TO  BE REVIEWED
    }

    /**
     * Retrieves all ingredient objects from the repository and lists them in the form
     * - used to assign the list returned from the repository and insert the into the ingredient variable in the form
     *
     * @return
     */
    @RequestMapping(value = "/getStock", method = RequestMethod.GET)
    public String getStock(Model model) {
        model.addAttribute("stock", stockService.getAll());
        return "stock";
    }
}

