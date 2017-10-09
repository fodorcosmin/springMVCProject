package ro.sci.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ro.sci.restaurant.model.Employee;
import ro.sci.restaurant.service.*;

import javax.servlet.http.HttpSession;

/**
 * Created by cosmin on 9/25/17.
 */
public class AbstractController {

    public static final String userSessionKey = "user_id";
    @Autowired
    //protected EmployeeRepository employeeService;
    protected EmployeeService employeeService;

    @Autowired
    protected ReservationService reservationService;

    @Autowired
    protected StockService stockService;

    @Autowired
    protected MenuService menuService;

    @Autowired
    protected CredentialsService credentialService;


    protected Employee getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        //return userId == null ? null : employeeDao.findByUid(userId);///////////////////////////////
        return userId == null ? null : employeeService.getByUid(userId);
    }

    protected void setUserInSession(HttpSession session, Employee user) {
        //session.setAttribute(userSessionKey, user.getUid());//////////////////////////////////////////
        session.setAttribute(userSessionKey, user.getId());
    }

}

