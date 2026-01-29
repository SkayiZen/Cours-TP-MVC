# TP MVC – Shop Management

## 📌 Description
This project is a simple console-based shop management application built using the **MVC (Model–View–Controller)** architecture.

Users can:
- View available products
- Add products to a shopping cart
- View the cart content
- Apply discounts
- Checkout and validate an order

The application is designed to be easily extensible and follows the **Open/Closed Principle (OCP)**.

---

## 🧱 Architecture

The project is structured using MVC:

## model/
- Product
- PhysicalProduct
- DigitalProduct
- ShoppingCart
- Order
## view/
- ShopView
## controller/
- ShopController
## Main.java

---

### Responsibilities
- **Model**: Business logic and data
- **View**: Console display and user input
- **Controller**: Application flow and coordination
- **Main**: Application entry point

---

## ⚙️ Key Features
- Interface-based product design (OCP)
- Physical and digital products
- Stock management
- Discount handling
- Order creation with ID and date
- Clean separation of concerns

---

## ▶️ How to Run
Compile and run `Main.java`.

---
