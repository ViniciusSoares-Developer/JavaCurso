package entites;

import entites.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dateHour = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Cliente cliente;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Cliente cliente) {
        this.setMoment(moment);
        this.setStatus(status);
        this.setCliente(cliente);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("ORDER SUMMARY:\n");
        text.append("Order moment: " + dateHour.format(this.getMoment()) + '\n');
        text.append("Order Status: " + this.getStatus() + '\n');
        text.append(String.format("Client: %s (%s) - %s\n",
                this.getCliente().getName(),
                date.format(this.getCliente().getBirthDate()),
                this.getCliente().getEmail()));
        text.append("Order items:\n");
        for(OrderItem o:orderItems){
            text.append(String.format("%s, $ %.2f, Quantity: %d, Subtotal: %.2f\n",
                    o.getProduct().getName(),
                    o.getProduct().getPrice(),
                    o.getQuantity(),
                    o.subTotal()));
        }
        text.append("Total: " + total() + '\n');

        return text.toString();
    }

    public Date getMoment() {
        return moment;
    }
    private void setMoment(Date moment) {
        this.moment = moment;
    }
    public OrderStatus getStatus() {
        return status;
    }
    private void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Cliente getCliente() {
        return cliente;
    }
    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem Item){
        orderItems.add(Item);
    }
    public void removeItem(OrderItem Item) {
        orderItems.remove(Item);
    }
    public Double total(){
        double tot = 0;
        for (OrderItem oi:orderItems) {
            tot += oi.subTotal();
        }
        return tot;
    }
}
