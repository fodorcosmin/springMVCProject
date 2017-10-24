package ro.sci.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by cosmin on 9/25/17.
 */
@Entity
@Table(name = "ingredients")
public class Ingredients extends AbstractEntity {                           //TODO am adaugat abstract entity aici


    private String item;
    private Double price;
    private Integer quantity;
    private List<Menu> menus;


    public Ingredients() {

    }

    @Column(name = "ingredient_name")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Column(name = "ingredient_price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "ingredient_quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;


    }

    @ManyToMany(mappedBy = "ingredients")
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
