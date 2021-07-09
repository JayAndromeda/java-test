package data;

public class Item {
    private final String name;
    private final String unit;
    private final float cost;

    public Item(String name, String unit, float cost) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
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

    @Override
    public String toString() {
        return String.format("%s cost %s per %s", getName(),getCost(),getUnit());
    }
}
