package csd214.bookstore.pojos;

import java.io.Serializable;

public abstract class Product extends Editable implements SaleableItem, Serializable {

    private String productId;
    private String name;
    private double price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    // New required fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
