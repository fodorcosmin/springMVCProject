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
@Controller
public class StockController extends AbstractController {

    @RequestMapping(value = "/stockhome", method = RequestMethod.GET)
    public String stockForm(Model model) {
        return "stockhome";
    }

    @RequestMapping(value = "/additem", method = RequestMethod.GET)
    public String addIngredientsForm(Model model) {
        model.addAttribute("ingredient", new Ingredients());
        return "additem";
    }

    @RequestMapping(value = "/additem", method = RequestMethod.POST)
    public String addIngredients(@ModelAttribute Ingredients ingredient) {
        stockService.add(ingredient);
        return "additem";
    }

    // TODO TO BE REVIEWED
    @RequestMapping(value = "/removeitem", method = RequestMethod.GET)
    public String removeIngredientsForm(Model model) {
        model.addAttribute("ingredient", new Ingredients());
        return "removeitem";
    }

    @RequestMapping(value = "/removeitem", method = RequestMethod.POST)
    public String removeIngredients(@ModelAttribute Ingredients ingredient) {
        stockService.remove(ingredient);
        return "removeitem"; //TODO TO  BE REVIEWED
    }

    @RequestMapping(value = "/getallitems", method = RequestMethod.GET)
    public String getStock(Model model) {
        model.addAttribute("items", stockService.getAll());
        return "getstock";
    }
}

