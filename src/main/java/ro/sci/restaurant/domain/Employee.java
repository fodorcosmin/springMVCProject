package ro.sci.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
public class Employee extends AbstractEntity {

    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    public Employee() {
    }


    public Employee(String name, String password, EmployeeRole role) {
        this.userName = name;
        this.password = password;
        this.employeeRole = role;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
        public EmployeeRole getEmployeeRoles() {
            return employeeRole;
        }
    */
    public String getEmployeeRole() {
        return this.employeeRole.toString();
    }

    public void setEmployeeRole(String role) {
        this.employeeRole = EmployeeRole.valueOf(role);
    }

    /*
    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
*/
    public boolean confirmPassWord(String password) {
        return this.password.equals(password);
    }
/*
    public static boolean confirmUserName(String usr)
    {
        if(userName.equals(usr))
        {
            return true;
        }
        return false;
    }
    */
}
