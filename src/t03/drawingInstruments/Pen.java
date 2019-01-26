package t03.drawingInstruments;

import t01.Colors;
import t01.PenTypes;
import t02.Stationery;

public class Pen extends DrawingInstruments {

    private PenTypes penType;

    public Pen(Colors color, PenTypes type) {
        super(Stationery.PEN.getPrice(), color);
        penType = type;
    }
    public Pen() {
        this(Colors.BLUE, PenTypes.BALLPOINT);
    }

    public void use() {
        System.out.println("This is a " + getColor() + " " + penType + " pen");
    }
}
