package ro.roro.mvc.model;

public class PhysicalProduct implements Product {

    private String name;
    private double price;
    private int quantityStock;
    private double weight;
    private double discount;

    public PhysicalProduct(String name, double price, int quantityStock, double weight) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.weight = weight;
        this.discount = 0.0;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getFinalPrice() {
        return price * (1 - discount / 100);
    }

    @Override
    public int getQuantityStock() {
        return quantityStock;
    }

    @Override
    public void reduceStock(int quantity) {
        if(quantity <= quantityStock) {
            quantityStock -= quantity;
        }
    }

    @Override
    public void applyDiscount(double percentage) {
        if(percentage >= 0 && percentage <= 100) {
            discount = percentage;
        }
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String getType() {
        return "Physical";
    }
}
