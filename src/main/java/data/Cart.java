package data;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.cart.add(item);
    }

    public void showCart() {
        System.out.print("Your cart: ");
        for (Item item : this.cart) {
            System.out.print(item.getQuantity() + " " + item.getName() + " ");
        }
    }

    public ArrayList<Item> returnCartList() {
        return this.cart;
    }

    public float addPromotions() {
        boolean soupPromotionActive = false;
        boolean hasBread = false;
        float breadPromo = .5f;
        float totalDiscount = 0f;
        for (Item item : this.cart) {
            if (item.getName().equals("apples")) {
                float promotionCost = .1f;
                totalDiscount+= (item.getCost()*promotionCost)*item.getQuantity();
            }
            if (item.getName().equals("soup") && item.getQuantity() >= 2) {
                soupPromotionActive = true;
            }
            if (item.getName().equals("bread")) {
                hasBread = true;
                breadPromo = item.getCost()/2;
            }
            if (hasBread && soupPromotionActive) {
               totalDiscount += breadPromo;
            }
        }
        return totalDiscount;
    }

}
