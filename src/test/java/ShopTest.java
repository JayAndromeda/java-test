import data.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

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
}