import data.Cart;
import data.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        printHeader();
        List<Item> items = initItems();
        printItems(items);
        shopping(items);
    }

    private static List<Item> initItems() {
        Item[] items =  new Item[]{
            new Item("soup", "can", 0.65f),
            new Item("bread", "loaf", 0.80f),
            new Item("milk", "bottle", 1.30f),
            new Item("apples", "single", 0.10f)
        };
        return new ArrayList<Item>(Arrays.asList(items));
    };

    private static void printHeader() {
        System.out.println("Welcome to Henry's Shop");
    }
    private static void printItems(List<Item> items) {
        for (Item item: items) {
            System.out.println(item.toString());
        }
    }

    private static void shopping(List<Item> items) {
        boolean isShopping = true;
        Cart cart = new Cart();
        while(isShopping) {
            System.out.println("To add an item simply type its name and hit enter");
            System.out.println("To stop shopping simply type exit and hit enter");
            Scanner scanner = new Scanner(System.in);
            String inputName = scanner.nextLine();
            if (inputName.equals("exit")) {
                isShopping = false;
            }
        }
    }
}
