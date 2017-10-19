package ro.sci.restaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ro.sci.restaurant.controller.AbstractController;
import ro.sci.restaurant.model.Credentials;
import ro.sci.restaurant.service.CredentialsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//import org.springframework.web.servlet.support.RequestContext;

/**
 * Created by cosmin on 10/16/17.
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CredentialsService credentialsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        boolean isLoggedIn = false;
        //restricted URLs
        List<String> authPages = Arrays.asList("/customerlookup", "/createcustomer", "/menu", "/addmenuitem", "/customerinformation", "/updatemenuitem", "/allcredentials",
                "/addItem", "/removeItem", "/getAllItems", "/addEmployee", "/updateEmployee", "/delEmployee", "/getAll");
        List<String> stockPages = Arrays.asList("/addItem", "/removeItem", "/getAllItems");
        List<String> adminPages = Arrays.asList("/addEmployee", "/updateEmployee", "/delEmployee", "/getAll");
        List<String> waiterPages = Arrays.asList("");

        // Require sign-in for auth pages
        if (authPages.contains(request.getRequestURI()) && isLoggedIn == false) {
            response.sendRedirect("/login");
            return false;
        }
        Credentials user;
        Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

        if (userId != null) {
            user = credentialsService.getByUid(userId);

            if (user != null) {
                isLoggedIn = true;

                if (user.getRole().equalsIgnoreCase("stockmanager") && !stockPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/addEmployee");
                }
                if (user.getRole().equalsIgnoreCase("admin") && !adminPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/addEmployee");
                }
                if (user.getRole().equalsIgnoreCase("waiter") && !waiterPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/addreservation");
                }
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws IOException {
        if (mav.getViewName().equals("home")) {
            mav.addObject("user", this.credentialsService.getByUid((Integer) request.getSession().getAttribute(AbstractController.userSessionKey)));
        }

    }

}