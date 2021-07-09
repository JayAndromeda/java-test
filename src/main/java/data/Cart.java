package data;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> item;

    public Cart() {
        this.item = new ArrayList<>();
    }

    public void add(Item item) {
        this.item.add(item);
    }
}
