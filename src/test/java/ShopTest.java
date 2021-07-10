import data.Cart;
import data.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShopTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void init(){
        System.setOut(new PrintStream(outContent));
        System.setProperty("line.separator", "\n");
    }

    @After
    public void cleanUp() {
        System.setOut(originalOut);
    }

    @Test
    public void canary() {
        assertTrue(true);
    }

    @Test
    public void printItemToString() {
        Item item = new Item("apples", "single", 0.85f, 0);
        String output = item.toString();
        assertEquals("apples cost 0.85 per single", output);
    }

    @Test
    public void printShowCart() {
        Item item1 = new Item("apples", "single", 0.85f, 2);
        Item item2 = new Item("bread", "loaf", 0.80f, 2);

        Cart cart = new Cart();

        cart.addItem(item1);
        cart.addItem(item2);

        cart.showCart();

        assertEquals("Your cart: 2 apples 2 bread ", outContent.toString());
    }

    @Test
    public void applePromotionalPriceApplies() {
        Item item = new Item("apples", "single", 0.1f, 2);
        Cart cart = new Cart();

        cart.addItem(item);
        cart.addPromotions();

        float total = getTotal(cart);

        assertEquals(.18f, total, 0.001);
    }

    @Test
    public void soupPromotionAppliesOnceToBread() {
        Item item1 = new Item("soup", "tin", 0.65f, 3);
        Item item2 = new Item("bread", "loaf", 0.80f, 2);
        Cart cart = new Cart();

        cart.addItem(item1);
        cart.addItem(item2);

        float total = getTotal(cart);

        assertEquals(3.15f, total, 0.001);
    }

    @Test
    public void sampleCartOne() {
        Item item1 = new Item("apples", "single", 0.1f, 6);
        Item item2 = new Item("milk", "bottle", 1.30f, 1);
        Cart cart = new Cart();

        cart.addItem(item1);
        cart.addItem(item2);

        float total = getTotal(cart);

        assertEquals(1.84f, total, 0.001);
    }

    @Test
    public void sampleCartTwo() {
        Item item1 = new Item("apples", "single", 0.1f, 3);
        Item item2 = new Item("bread", "loaf", 0.80f, 1);
        Item item3 = new Item("soup", "tin", 0.65f, 2);
        Cart cart = new Cart();

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        float total = getTotal(cart);

        assertEquals(1.97f, total, 0.001);
    }

    private float getTotal(Cart cart) {
        float total = 0f;
        for (Item item : cart.returnCartList()) {
            total += item.getCost() * item.getQuantity();
        }
        total -= cart.addPromotions();
        return total;
    }
}