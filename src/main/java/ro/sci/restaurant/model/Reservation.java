package ro.sci.restaurant.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {

    private final Integer capacity = 30;
    private Customer customer;
    private Date reservationDate;
//    private List<Table> tables;


    public Reservation() {
    }



    @Transient
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "reservation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Date getReservationDate() {
        return reservationDate;
    }

    @SuppressWarnings("unused")
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

//    @ElementCollection
//    public List<Table> getTables() {
//        return tables;
//    }
//
//    public void setTables(List<Table> tables) {
//        this.tables = tables;
//    }


    public Integer getCapacity() {
        return capacity;
    }
}
