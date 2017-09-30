package ro.sci.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.domain.Ingredients;

import javax.servlet.http.HttpServletRequest;

//import ro.sci.restaurant.domain.Item;

//
///**
// * Created by cosmin on 9/23/17.
// */
@Controller
public class StockController extends AbstractController {

    @RequestMapping(value = "/restaurant/addItem", method = RequestMethod.GET)
    public String addIngredientsForm() {
        //return "addItem";
        return "success";
    }

    @RequestMapping(value = "/restaurant/addItem", method = RequestMethod.POST)
    public String addIngredients(HttpServletRequest request) {
        String item = request.getParameter("item");
        String quantity = request.getParameter("quantity");
        Ingredients ingredients = new Ingredients(item, Integer.parseInt(quantity));
        stockService.add(ingredients); //TODO
        return "ingredientsAdded";
    }

    // TODO TO BE REVIEWED
    @RequestMapping(value = "/restaurant/removeItem", method = RequestMethod.GET)
    public String removeIngredientsForm() {
        //return "removeItem";
        return "success";
    }

    @RequestMapping(value = "/restaurant/removeItem", method = RequestMethod.POST)
    public String removeIngredients(HttpServletRequest request) {
        String item = request.getParameter("item");
        String quantity = request.getParameter("quantity");
        Ingredients ingredients = new Ingredients(item, Integer.parseInt(quantity));
        for (Ingredients ing : stockService.getAll()) //TODO
        {
            if (ing.getItem().equals(ingredients.getItem())) {
                ing.setQuantity(ing.getQuantity() - ingredients.getQuantity());
                if (ing.getQuantity() <= 0) {
                    stockService.delete(ing.getUid()); //todo
                }
            }
        }
        return "ingredientsRemoved"; //TODO TO  BE REVIEWED
    }
}

