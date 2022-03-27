package entities;

import entities.interfaces.IProduct;

public class Product implements IProduct{
    private String name;
    private Double price;

    public Product(String name, Double price) {
        setName(name);
        setPrice(price);
    }
    @Override
    public String toString() {
        return getName()
                + priceTag();
    }

    @Override
    public String priceTag() {
        return " $" + getPrice();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return this.price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
