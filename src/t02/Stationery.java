package t02;

/**
 * Every stationery that employee can have with its price
 */
public enum Stationery {
    PEN(50), PENCIL(20), BRUSH(40),
    STAPLER(150), TAPE(60), SCISSORS(200), RULER(30),
    PAPER(2), NOTEBOOK(100), STICKERS(70);

    private int price;

    Stationery(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
