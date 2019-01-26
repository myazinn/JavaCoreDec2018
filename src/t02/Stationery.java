package t02;

/**
 * Every stationery that employee can have with its price
 */
public enum Stationery {
    PEN(50), PENCIL(20), SCISSORS(200), RULER(30), ERASER(20), NOTEBOOK(100), STAPLER(150), TAPE(60);

    private int price;

    Stationery(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
