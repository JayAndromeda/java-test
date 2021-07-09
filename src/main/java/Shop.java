import data.Item;

import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        printHeader();
        Item[] items = initItems();
        printItems(items);
        shopping();
    }

    private static Item[] initItems() {
        return new Item[]{
            new Item("soup", "can", 0.65f),
            new Item("bread", "loaf", 0.80f),
            new Item("milk", "bottle", 1.30f),
            new Item("apples", "single", 0.10f)
        };
    };

    private static void printHeader() {
        System.out.println("Welcome to Henry's Shop");
    }
    private static void printItems(Item[] items) {
        for (Item item: items) {
            System.out.println(item.toString());
        }
    }

    private static void shopping() {
        boolean isShopping = true;
        while(isShopping) {
            System.out.println("To add an item simply type its name and hit enter");
            System.out.println("To stop shopping simply type exit and hit enter");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("exit")) {
                isShopping = false;
            }
        }
    }
}
