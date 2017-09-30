package ro.sci.restaurant.domain;

import javax.persistence.Entity;

///**
// * Created by cosmin on 9/25/17.
// */

@Entity
public class Customer extends AbstractEntity {

    private String name;
    private String lastname;
    private String date;

    public Customer(String name, String lastname, String date) {
        this.name = name;
        this.lastname = lastname;
        this.date = date;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

