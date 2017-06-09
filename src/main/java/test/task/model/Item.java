package test.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String mpn;
    private String status;
    private ShopDescription shopDescription;

    public Item() {
    }

    public Item(String mpn, String status,
                ShopDescription shopDescription) {
        this.mpn = mpn;
        this.status = status;
        this.shopDescription = shopDescription;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShopDescription getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(ShopDescription shopDescription) {
        this.shopDescription = shopDescription;
    }
}
