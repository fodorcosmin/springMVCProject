//
//package ro.sci.restaurant;
//
///**
// * Created by cosmin on 9/25/17.
// */
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import ro.sci.restaurant.controller.AbstractController;
//import employeeadm.model.Employee;
//import ro.sci.restaurant.repository.EmployeeRepository;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//
//        //restricted URLs
//        List<String> authPages = Arrays.asList("/customerlookup", "/createcustomer", "/menu", "/addmenuitems", "/customerinformation", "/updatemenuitem");
//
//        // Require sign-in for auth pages
//        if (authPages.contains(request.getRequestURI())) {
//
//            boolean isLoggedIn = false;
//            Employee user;
//            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey); //TODO MODIFIED FROM INT TO STRING //
//
//            if (userId != null) {
//                //user = employeeDao.findByUid(userId);//////////////////////////////////
//                user = employeeRepository.findOne(userId);
//
//                if (user != null) {
//                    isLoggedIn = true;
//                }
//            }
//
//            // If user not logged in, redirect to login page
//            if (!isLoggedIn) {
//                response.sendRedirect("/login");
//                //response.sendRedirect("/success");
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
//
