package data;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.cart.add(item);
    }
}
