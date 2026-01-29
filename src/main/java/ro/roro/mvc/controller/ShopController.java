package ro.roro.mvc.controller;

import ro.roro.mvc.model.Order;
import ro.roro.mvc.model.PhysicalProduct;
import ro.roro.mvc.model.Product;
import ro.roro.mvc.model.ShoppingCart;
import ro.roro.mvc.view.ShopView;

import java.util.ArrayList;
import java.util.List;

public class ShopController {

    private ShopView shopView;
    private List<Product> productsList = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();

    public ShopController(ShopView shopView) {
        this.shopView = shopView;
        initializeProducts();
    }

    private void initializeProducts() {
        Product mouse = new PhysicalProduct("Gaming Mouse", 59.99, 100, 0.5);
        Product keyboard = new PhysicalProduct("Mechanical Keyboard", 129.99, 50, 1.2);
        Product monitor = new PhysicalProduct("4K Monitor", 399.99, 30, 4.5);

        monitor.applyDiscount(20);

        productsList.add(mouse);
        productsList.add(keyboard);
        productsList.add(monitor);
    }

    private void displayProducts() {
        shopView.displayProducts(productsList);
    }

    private void addProductToCart(int productIndex) {
        if (productIndex >= 0 && productIndex < productsList.size()) {
            Product selectedProduct = productsList.get(productIndex);
            if (selectedProduct.getQuantityStock() > 0) {
                shoppingCart.addProduct(selectedProduct);
                selectedProduct.reduceStock(1);
                shopView.displayMessage(selectedProduct.getName() + " added to cart.");
            } else {
                shopView.displayMessage("Sorry, " + selectedProduct.getName() + " is out of stock.");
            }
        } else {
            shopView.displayMessage("Invalid product selection.");
        }
    }

    private void viewCart() {
        List<Product> cartItems = shoppingCart.getItems();
        double totalPrice = shoppingCart.getTotalPrice();
        shopView.displayCart(cartItems, totalPrice);
    }

    private void validateCheckout() {
        if (shoppingCart.getItems().isEmpty()) {
            shopView.displayMessage("Your cart is empty.");
            return;
        }

        Order order = new Order(
                new ArrayList<>(shoppingCart.getItems()),
                shoppingCart.getTotalPrice()
        );

        shopView.displayOrderConfirmation(order);
        shoppingCart.clearCart();
    }


    public void run() {
        shopView.displayWelcome();
        boolean running = true;
        while (running) {
            shopView.displayMenu();
            int choice = shopView.getUserChoice();
            switch (choice) {
                case 1:
                    displayProducts();
                    int productIndex = shopView.selectProductIndex();
                    addProductToCart(productIndex);
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    validateCheckout();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    shopView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }


}
