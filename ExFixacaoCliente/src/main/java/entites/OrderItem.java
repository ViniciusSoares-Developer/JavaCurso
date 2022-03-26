package entites;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem(int quantity, Product product) {
        setQuantity(quantity);
        setProduct(product);
        setPrice(subTotal());
    }

    public Integer getQuantity() {
        return quantity;
    }
    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    public Product getProduct() {
        return product;
    }
    private void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal(){
        return product.getPrice() * this.getQuantity();
    }
}
