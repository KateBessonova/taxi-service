
package models;

public class Order {
 
    private int orderId;
    private int customerId;
    private String from;
    private String to;
    private int price;

    public Order(int orderId, int customerId, String from, String to, int price) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", from=" + from + ", to=" + to + ", price=" + price + '}';
    }
    
}
