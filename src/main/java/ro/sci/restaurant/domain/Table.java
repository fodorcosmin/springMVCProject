package ro.sci.restaurant.domain;

import ro.sci.restaurant.service.MenuService;

/**
 * Created by cosmin on 9/25/17.
 */

public class Table extends AbstractEntity {

    private Employee employee;
    private MenuService menu;
    private boolean isAvailable;

    public Table() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MenuService getMenu() {
        return menu;
    }

    public void setMenu(MenuService menu) {
        this.menu = menu;
    }
}
