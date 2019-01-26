package t03.drawingInstruments;

import t01.Colors;
import t02.Stationery;

public class Pencil extends DrawingInstruments {

    public Pencil(Colors color) {
        super(Stationery.PENCIL.getPrice(), color);
    }
    public Pencil() {
        this(Colors.BLACK);
    }

    public void use() {
        System.out.println("This is a " + getColor() + " pencil");
    }
}
