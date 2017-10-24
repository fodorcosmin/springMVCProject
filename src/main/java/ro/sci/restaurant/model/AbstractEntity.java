package ro.sci.restaurant.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by cosmin on 10/4/17.
 */

@MappedSuperclass
public abstract class AbstractEntity {

    private int uid;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
