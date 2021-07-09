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
}