import data.Cart;
import data.Item;

import java.util.*;

public class Shop {

    private static final String LINEBREAK = "----------";

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
            new Item("apples", "apple", 0.10f)
        };
        return new ArrayList<Item>(Arrays.asList(items));
    };

    private static void printHeader() {
        System.out.println("Welcome to Henry's Shop");
        System.out.println(LINEBREAK);
    }
    private static void printItems(List<Item> items) {
        for (Item item: items) {
            System.out.println(item.toString());
        }
        System.out.println(LINEBREAK);
    }

    private static void shopping(List<Item> items) {
        boolean isShopping = true;
        Cart cart = new Cart();
        System.out.println("To add an item simply type its name and hit enter");
        System.out.println("To stop shopping simply type exit and hit enter");
        while(isShopping) {
            Scanner scanner = new Scanner(System.in);
            String inputName = scanner.nextLine();
            if (inputName.equals("exit")) {
                isShopping = false;
            }
        }
    }
}
