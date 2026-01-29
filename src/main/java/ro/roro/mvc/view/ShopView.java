package ro.roro.mvc.view;

import ro.roro.mvc.model.Product;
import ro.roro.mvc.model.PhysicalProduct;
import ro.roro.mvc.model.Order;

import java.util.List;
import java.util.Scanner;

public class ShopView {

    private Scanner scanner = new Scanner(System.in);

    public void displayWelcome() {
        System.out.println("Welcome to the Shop!");
    }

    public void displayMenu() {
        System.out.println("======= MENU =======");
        System.out.println("1. View Products");
        System.out.println("2. View Cart");
        System.out.println("3. Checkout");
        System.out.println("4. Exit");
        System.out.println("=====================");
        System.out.print("Choose an option: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void displayProducts(List<Product> products) {
        System.out.println("======= Products =======");

        for (int item = 0; item < products.size(); item++) {
            Product product = products.get(item);

            boolean isPhysical = product instanceof PhysicalProduct;
            double weight = isPhysical ? ((PhysicalProduct) product).getWeight() : 0;

            if (product.getFinalPrice() < product.getPrice()) {
                if (isPhysical) {
                    System.out.printf(
                            "%d - %s (%s) : %.2f€ → %.2f€ | %.2f kg | Stock: %d%n",
                            item,
                            product.getName(),
                            product.getType(),
                            product.getPrice(),
                            product.getFinalPrice(),
                            weight,
                            product.getQuantityStock()
                    );
                } else {
                    System.out.printf(
                            "%d - %s (%s) : %.2f€ → %.2f€ | Stock: %d%n",
                            item,
                            product.getName(),
                            product.getType(),
                            product.getPrice(),
                            product.getFinalPrice(),
                            product.getQuantityStock()
                    );
                }
            } else if (isPhysical) {
                System.out.printf(
                        "%d - %s (%s) : %.2f€ | %.2f kg | Stock: %d%n",
                        item,
                        product.getName(),
                        product.getType(),
                        product.getFinalPrice(),
                        weight,
                        product.getQuantityStock()
                );
            } else {
                System.out.printf(
                        "%d - %s (%s) : %.2f€ | Stock: %d%n",
                        item,
                        product.getName(),
                        product.getType(),
                        product.getFinalPrice(),
                        product.getQuantityStock()
                );
            }
        }
    }

    public int selectProductIndex() {
        System.out.print("Enter the product number to add to cart: ");
        return scanner.nextInt();
    }

    public void displayCart(List<Product> cartItems, double totalPrice) {
        System.out.println("======= CART =======");

        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        for (Product product : cartItems) {
            System.out.printf("- %s : %.2f€%n", product.getName(), product.getFinalPrice());
        }

        System.out.printf("Total Price: %.2f€%n", totalPrice);
    }

    public void displayOrderConfirmation(Order order) {
        System.out.println("======= ORDER CONFIRMATION =======");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Order Date: " + order.getDate());

        for (Product product : order.getProduct()) {
            if (product.getFinalPrice() < product.getPrice()) {
                System.out.printf(
                        "- %s : %.2f€ → %.2f€%n",
                        product.getName(),
                        product.getPrice(),
                        product.getFinalPrice()
                );
            } else {
                System.out.printf(
                        "- %s : %.2f€%n",
                        product.getName(),
                        product.getFinalPrice()
                );
            }
        }

        System.out.printf("Total Paid: %.2f€%n", order.getTotalPrice());
        System.out.println("=================================");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
