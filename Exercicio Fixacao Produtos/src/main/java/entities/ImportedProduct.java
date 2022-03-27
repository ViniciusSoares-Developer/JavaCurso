package entities;

public class ImportedProduct extends Product {
    private Double customsfee;

    public ImportedProduct(String name, Double price, Double customsfee) {
        super(name, price);
        setCustomsfee(customsfee);
    }
    @Override
    public String toString() {
        return getName()
                +" $" + totalPrice()
                + " (Customs fee: $"+getCustomsfee()+")";
    }

    @Override
    public String priceTag() {
        return "$ "+(getPrice()+getCustomsfee());
    }
    public Double totalPrice(){
        return getPrice() + getCustomsfee();
    }

    public Double getCustomsfee() {
        return customsfee;
    }
    public void setCustomsfee(Double customsfee) {
        this.customsfee = customsfee;
    }
}
