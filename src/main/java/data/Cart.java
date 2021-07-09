package data;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.cart.add(item);
    }

    public void showCart() {
        System.out.print("Your cart: ");
        for (Item item : this.cart) {
            System.out.print(item.getQuantity() + " " + item.getName() + " ");
        }
    }
}
