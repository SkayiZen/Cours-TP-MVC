package ro.roro.mvc;

import ro.roro.mvc.controller.ShopController;
import ro.roro.mvc.view.ShopView;

public class Main {

    public static void main(String[] args) {
        ShopController controller = new ShopController(new ShopView());
        controller.run();
    }

}
