package test.task.model;

import test.task.enums.StockAvailability;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Long id;
    private double price;
    private StockAvailability stockAvailability;


   /* @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;*/


    public String stock;


    public Stock() {
    }

    public Stock(double price, StockAvailability stockAvailability) {
        super();
        this.price = price;
        this.stockAvailability = stockAvailability;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StockAvailability getStockAvailability() {
        return stockAvailability;
    }

    public void setStockAvailability(StockAvailability stockAvailability) {
        this.stockAvailability = stockAvailability;
    }
}


