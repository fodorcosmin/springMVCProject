package ro.sci.restaurant.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
//
@Entity
@Table(name = "menu")
public class Menu extends AbstractEntity {

    private String dishName;
    private int dishPrice;
    private List<Ingredients> ingredients;


    public Menu() {
    }


    @NotNull
    @Column(name = "dish_name")
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @NotNull
    @Column(name = "dish_price")
    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "menu_ingredients", joinColumns = @JoinColumn(name = "menu_uid"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_uid"))
    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
