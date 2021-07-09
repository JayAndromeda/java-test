import data.Item;

public class Shop {
    public static void main(String[] args) {
        printHeader();
        Item[] items = initItems();
        printItems(items);
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
}
