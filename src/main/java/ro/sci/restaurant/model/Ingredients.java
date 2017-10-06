package ro.sci.restaurant.model;

import javax.persistence.Entity;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
public class Ingredients extends AbstractEntity {                           //TODO am adaugat abstract entity aici


    private String item;
    private int quantity;

    public Ingredients() {

    }

    public Ingredients(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
