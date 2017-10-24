package ro.sci.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "credentials")
public class Credentials extends AbstractEntity {


    private String username;
    private String password;
    private String role;
    private Employee employee;
    public Credentials() {
    }


    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne
    @JoinColumn(name = "uid")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
