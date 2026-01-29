package ro.roro.mvc.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private static int nextOrderId = 1;
    private int orderId;
    private List<Product> product;
    private double totalPrice;
    private LocalDateTime date;

    public Order(List<Product> product, double totalPrice) {
        this.orderId = nextOrderId++;
        this.product = product;
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
