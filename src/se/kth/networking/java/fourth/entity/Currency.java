package se.kth.networking.java.fourth.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nick on 11/21/2016.
 */
@Entity
@Table(name = "currencies")
@NamedQueries(
        {
                @NamedQuery(name = "Currency.getAll", query = "SELECT c FROM Currency c")
        }
)
public class Currency implements Serializable {
    @Id
    @Column(name = "country_code")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "worth")
    private String worth;

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }
}
