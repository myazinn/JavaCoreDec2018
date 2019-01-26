package t03;

import java.util.Objects;

abstract public class StationeryClass {
    private int price;

    int getPrice() {
        return price;
    }

    public StationeryClass(int price) {
        this.price = price;
    }

    public abstract void use();

}
