package data;

import java.util.Arrays;

public class Item {
    private final String name;
    private final String unit;
    private float cost;
    private int quantity;

    public Item(String name, String unit, float cost, int quantity) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public float getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%s cost %s per %s", getName(),getCost(),getUnit());
    }
}
