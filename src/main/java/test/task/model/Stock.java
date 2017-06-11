package test.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import test.task.enums.Availability;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "stocks")
public class Stock implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private int availability;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itemsStocks",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    public Stock() {
    }

    public Stock(double price, int availability, List<Item> items) {
        this.price = price;
        this.availability = availability;
        this.items = items;
    }

    public Stock(double price) {
        super();
        this.price = price;
        this.availability = Availability.NO.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}


