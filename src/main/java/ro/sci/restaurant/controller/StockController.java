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

    @RequestMapping(value = "/restaurant/addItem", method = RequestMethod.GET)
    public String addIngredientsForm(Model model) {
        model.addAttribute("itemAdd", new Ingredients());
        return "additem";
    }

    @RequestMapping(value = "/restaurant/addItem", method = RequestMethod.POST)
    public String addIngredients(@ModelAttribute Ingredients itemAdd) {

        for (Ingredients ingr : stockService.getAll()) {
            if (ingr.getItem().equals(itemAdd.getItem())) {
                ingr.setQuantity(ingr.getQuantity() + itemAdd.getQuantity());
            } else {
                stockService.add(itemAdd);
            }
        }
        return "additem";
    }

    // TODO TO BE REVIEWED
    @RequestMapping(value = "/restaurant/removeItem", method = RequestMethod.GET)
    public String removeIngredientsForm(Model model) {
        model.addAttribute("itemRemove", new Ingredients());
        return "additem";
    }

    @RequestMapping(value = "/restaurant/removeItem", method = RequestMethod.POST)
    public String removeIngredients(@ModelAttribute Ingredients itemRemove) {

        for (Ingredients ing : stockService.getAll()) //TODO
        {
            if (ing.getItem().equals(itemRemove.getItem())) {
                ing.setQuantity(ing.getQuantity() - itemRemove.getQuantity());
                if (ing.getQuantity() <= 0) {
                    stockService.delete(ing.getUid()); //todo
                }
            }
        }
        return "additem"; //TODO TO  BE REVIEWED
    }

    @RequestMapping(value = "/restaurant/getAllItems", method = RequestMethod.GET)
    public String getStock(Model model) {
        model.addAttribute("items", stockService.getAll());
        return "getstock";
    }
}

