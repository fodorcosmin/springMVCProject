package ro.sci.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "stock")
public class Stock extends AbstractEntity {

    private String name;
    private Integer quantity;
    private Double price_per_unit;
    private Double totalPrice;


    public Stock() {
    }
}
