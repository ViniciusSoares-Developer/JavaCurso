package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private Date manufactureDate;

    private SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        setManufactureDate(manufactureDate);
    }
    @Override
    public String toString() {
        return getName()
                +"(Used)" + priceTag()
                +" (Manufacturing date: "+date.format(getManufactureDate())+")";
    }

    @Override
    public String priceTag() {
        return " $"+(getPrice());
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }
    private void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
