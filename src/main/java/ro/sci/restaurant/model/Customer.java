package ro.sci.restaurant.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

///**
// * Created by cosmin on 9/25/17.
// */

@Entity
@Table(name = "customers")
@SecondaryTable(name = "reservations")
public class Customer extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String comments;
    private Integer seats;
    private Date reservationDate;



    public Customer() {
    }

    @NotNull
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @SuppressWarnings("unused")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @SuppressWarnings("unused")
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }


    @NotNull
    @Email
    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @Column(name = "phone_number", unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @SuppressWarnings("unused")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(table="reservations")
    public String getComments() {
        return comments;
    }
    @SuppressWarnings(value = "unchecked")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(table="reservations")
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Column(table="reservations")
    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}

