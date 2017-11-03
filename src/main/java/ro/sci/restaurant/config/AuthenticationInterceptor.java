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


///**
// * Created by Andrei on 10/16/17.
// */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CredentialsService credentialsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        boolean isLoggedIn = false;
        //restricted URLs
        List<String> authPages = Arrays.asList("/addmenuitem", "/additem", "/removeitem", "/getallitems", "/addEmployee", "/removeEmployee", "/getAllEmployees",
                "/admin", "/waiter", "/stock", "/getallcredentials", "/addEmployeeCredentials");
        List<String> stockPages = Arrays.asList("/additem", "/removeitem", "/getStock", "/manager", "/logout");
        List<String> adminPages = Arrays.asList("/admin", "/addEmployee", "/removeEmployee", "/getEmployees", "/getCredentials", "/logout", "/addEmployeeCredentials", "/tasks");
        List<String> waiterPages = Arrays.asList("/waiter", "/addmenuitem", "/removemenuitem", "/menu", "/getMenus", "/logout", "/reservations");


        Credentials user;
        Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

        if (userId != null) {
            user = credentialsService.getByUid(userId);

            if (user != null) {
                isLoggedIn = true;

                if (user.getRole().equalsIgnoreCase("manager") && !stockPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/manager");
                }
                if (user.getRole().equalsIgnoreCase("admin") && !adminPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/admin");
                }
                if (user.getRole().equalsIgnoreCase("waiter") && !waiterPages.contains(request.getRequestURI())) {
                    response.sendRedirect("/waiter");
                }
            }
            if (authPages.contains(request.getRequestURI()) && !isLoggedIn) {
                response.sendRedirect("/login");
                return false;
            }


        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws IOException {

        if (mav.getViewName().equals("manager") || mav.getViewName().equals("admin") || mav.getViewName().equals("waiter")) {
            mav.addObject("user", this.credentialsService.getByUid((Integer) request.getSession().getAttribute(AbstractController.userSessionKey)));
        }
    }

}