package ro.sci.restaurant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.restaurant.domain.Menu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cosmin on 9/23/17.
 */
@Controller
public class MenuController extends AbstractController {

    @RequestMapping(value = "/addmenuitems", method = RequestMethod.GET)
    public String signupForm(Model model) {
        //return "addmenuitem";
        model.addAttribute("items", "spanac");
        return "addmenuitem";
    }

    @RequestMapping(value = "/addmenuitems", method = RequestMethod.POST)
    public String signup(HttpServletRequest request, Model model) {

        // TODO - implement signup
        // get parameters from request
        String name = request.getParameter("name");
        //String description = request.getParameter("description");
        String price = request.getParameter("price");


        //TODO - USED TO VERIFY THAT THE PRICE FORMAT AND DISH NAME IS CORRECT
        //
        //MenuItem mi = menuItemDao.findByName(name);
        //Menu mi = menuService.findByName(name);
        Menu mi = new Menu();
        if (mi == null) {
            //MenuItem newMenuItem = new MenuItem(name, description, price);
            Menu newMenu = new Menu(name, price);
            menuService.add(newMenu);

            return "redirect:/menu";
        } else {
            model.addAttribute("name_error", "That menu item already exists!");
            model.addAttribute("name", name);
            //model.addAttribute("description", description);
            model.addAttribute("price", price);
            return "addmenuitem";
        }

    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) {
        //List<MenuItem> menuitems = menuItemDao.findAll();
        List<Menu> menuitems = menuService.getAll();
        model.addAttribute("menuitems", menuitems);
        //return "menu";
        return "success";
    }

//    @RequestMapping(value = "/updatemenuitem/{uid}", method = RequestMethod.GET)
//    public String menuItem(@PathVariable int uid, Model model) {
//
//        //MenuItem m = menuItemDao.findByUid(uid);
//        Menu m = menuService.update(uid);
//        if (m == null) {
//
////            model.addAttribute("error", "There is no menu item with that id " + uid); //TODO REVIEW LATER
////            return "404";
////        }
////
////        model.addAttribute("menuitem", m);
////        return "updatemenuitem";
}

//TODO - USED ONLY FOR UPDATES OF THE DISHES -- MUST ADD REMOVE MENU ITEM
//TODO - CREATE A NEW MENUITEM UPDATE -- SHORTER AND MORE READABLE
//	/*
//	@RequestMapping(value = "/updatemenuitem/{uid}", method = RequestMethod.POST)
//	public String updateMenuItem(HttpServletRequest request, @PathVariable int uid, Model model) {
//
//		String name = request.getParameter("name");
//		String description = request.getParameter("description");
//		String price = request.getParameter("price");
//		String status = request.getParameter("status");
//
//
//		// validate parameters (price, name)
//		if (!MenuItem.isValidPrice(price)) {
//			model.addAttribute("price_error", "Price format is incorrect. Valid price must a be a decimal number.");
//			model.addAttribute("name", name);
//			model.addAttribute("description", description);
//			return "addmenuitem";
//		}
//
//		////MenuItem tempItem = new MenuItem(name, description, price, status);
//		//MenuItem currentItem = menuItemDao.findByUid(uid);
//		////MenuItem currentItem = menuRepository.findOne(uid);
//		////if (!tempItem.getName().equals(currentItem.getName())) {
//
//
//			//MenuItem mi = menuItemDao.findByName(name);
//			MenuItem mi = menuRepository.fingByDishName(name);
//			if (mi == null) {
//				currentItem.setName(name);
//				currentItem.setDescription(description);
//				currentItem.setPrice(price);
//				currentItem.setStatus(status);
//				//menuRepository.save(currentItem);
//				menuRepository.save(currentItem);
//
//				return "redirect:/menu";
//			} else {
//				model.addAttribute("name_error", "That menu item name already exists!");
//				tempItem.setName("");
//				model.addAttribute("menuitem", tempItem);
//
//				return "updatemenuitem";
//			}
//		}	else {
//			currentItem.setDescription(description);
//			currentItem.setPrice(price);
//			currentItem.setStatus(status);
//			//menuItemDao.save(currentItem);
//			menuRepository.save(currentItem);
//
//			return "redirect:/menu";
//		}
//	}
//	*/
//
