package ro.sci.restaurant.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "stock")
public class Stock {

    private Ingredients ingredients;
    private Double quantity;
    private Double price_per_unit;
    private Double totalPrice;


    public Stock() {
    }

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "uid", unique = true, nullable = false, updatable = false)
    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(Double price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ingredients=" + ingredients +
                ", quantity=" + quantity +
                ", price_per_unit=" + price_per_unit +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
