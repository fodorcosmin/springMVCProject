package ro.sci.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "ingredients")
public class Ingredients extends AbstractEntity {                           //TODO am adaugat abstract entity aici


    private String item;
    private Integer quantity;

    public Ingredients() {

    }

    @Column(name = "ingredient_name")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Column(name = "ingredient_quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;


    }

}
