package t03.drawingInstruments;

import t01.Colors;
import t03.StationeryClass;

abstract class DrawingInstruments extends StationeryClass {
    private Colors color;

    DrawingInstruments(int price, String name, Colors color) {
        super(price, name);
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }
}
