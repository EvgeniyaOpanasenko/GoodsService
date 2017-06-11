package test.task.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "items")
public class Item implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mpn;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Stock stock;

    /*@OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<Stock> stockDetails = new ArrayList<>();
*/
    public Item() {
    }

    public Item(Stock stock) {
        this.mpn = UUID.randomUUID().toString();
        this.stock = stock;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }


}