package ro.roro.mvc.model;

public interface Product {

        String getName();
        double getPrice();
        double getFinalPrice();
        int getQuantityStock();
        void reduceStock(int quantity);
        void applyDiscount(double percentage);
        String getType();

}
