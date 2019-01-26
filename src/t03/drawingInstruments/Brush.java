package t03.drawingInstruments;

import t01.Colors;
import t02.Stationery;

public class Brush extends DrawingInstruments{
    public Brush(Colors color) {
        super(Stationery.BRUSH.getPrice(), Stationery.BRUSH.name() + " (" + color + ")", color);
    }

    public Brush(){
        this(Colors.RED);
    }

    public void use() {
        System.out.println("This is a " + getColor() + " brush");
    }
}
