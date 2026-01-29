package ro.roro.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getFinalPrice).sum();
    }

    public void clearCart() {
        items.clear();
    }

}
