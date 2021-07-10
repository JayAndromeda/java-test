import data.Cart;
import data.Item;

import java.text.DecimalFormat;
import java.util.*;

public class Shop {

    private static final String LINEBREAK = "----------";

    public static void main(String[] args) {
        printHeader();
        List<Item> items = initItems();
        printItems(items);
        Cart cart = shopping(items);
        checkout(cart);
    }

    private static List<Item> initItems() {
        Item[] items =  new Item[]{
            new Item("soup", "tin", 0.65f, 0),
            new Item("bread", "loaf", 0.80f, 0),
            new Item("milk", "bottle", 1.30f,0 ),
            new Item("apples", "apple", 0.10f, 0)
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

    private static Cart shopping(List<Item> items) {
        boolean isShopping = true;
        boolean found = false;
        Cart cart = new Cart();
        System.out.println("To add an item simply type its name and hit enter");
        System.out.println("To stop shopping simply type exit and hit enter");
        while(isShopping) {
            Scanner scanner = new Scanner(System.in);
            String inputName = scanner.nextLine();
            if (inputName.equals("exit")) {
                isShopping = false;
            }
            for (Item item : items) {
                if (item.getName().equals(inputName)) {
                    System.out.println("In what quantity? integer input");
                    int quantity = scanner.nextInt();
                    item.setQuantity(quantity);
                    cart.addItem(item);
                    System.out.println(quantity + " " + inputName +" added to cart");
                    found = true;
                    System.out.println("Anything else? or type exit");
                    break;
                }
            }
            if (!found) {
                System.out.println("item not found");
            }
        }
        return cart;
    }

    private static void checkout(Cart cart) {
        cart.showCart();
        System.out.println(LINEBREAK);
        System.out.println();
        float discounts = cart.addPromotions();
        float total = cart.total();
        DecimalFormat formatter = new DecimalFormat("#.00");

        System.out.println("Your shopping total is " + formatter.format(total));
    }
}
