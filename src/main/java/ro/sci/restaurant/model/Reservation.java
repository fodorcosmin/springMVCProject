package ro.sci.restaurant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {

    private int availableSeats = 30;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer seats;
    private Date reservationDate;
    private String comments;


    public Reservation() {
    }


    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "seats")
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Column(name = "available_seats", updatable = true)
    public int getAvailableSeats() {
        return availableSeats - getSeats();
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Column(name = "reservation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getReservationDate() {
        return reservationDate;
    }

    @SuppressWarnings("unused")
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }


    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
