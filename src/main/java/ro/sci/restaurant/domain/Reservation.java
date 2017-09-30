package ro.sci.restaurant.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
public class Reservation extends AbstractEntity {

    private Customer customer;
    private Date reservationDate;
    private List<Table> tables;


    public Reservation() {
    }

    public Reservation(Customer customer, Date reservationDate) {
        this.customer = customer;
        this.reservationDate = reservationDate;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationDateString() {
        return this.reservationDate.toString();
    }

    @ElementCollection
    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
