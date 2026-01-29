package ro.roro.mvc.model;

public class DigitalProduct implements Product {

    private String name;
    private double initPrice;
    private double finalPrice;
    private String licenseType;

    public DigitalProduct(String name, double price, String licenseType) {
        this.name = name;
        this.initPrice = price;
        this.finalPrice = price;
        this.licenseType = licenseType;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return initPrice;
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public int getQuantityStock() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void reduceStock(int quantity) {

    }

    @Override
    public void applyDiscount(double percentage) {
        if(percentage >= 0 && percentage <= 100) {
            finalPrice = initPrice * (1 - percentage / 100);
        }
    }

    @Override
    public String getType() {
        return "Digital";
    }
}
