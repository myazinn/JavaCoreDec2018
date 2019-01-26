package t03;

import java.util.Objects;

abstract public class StationeryClass{
    private int price;
    private String name;

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public StationeryClass(int price, String name) {
        this.price = price;
        this.name = name.toLowerCase();
    }

    public abstract void use();

}
