package t03.actionInstruments;

import t02.Stationery;

public class Ruler extends ActionInstruments {
    private int length;

    public Ruler(int length) {
        super(Stationery.RULER.getPrice(), Stationery.RULER.name() + length + " cm ",length + "rule them all");
        this.length = length;
    }

    public void use() {
        System.out.println(length + " cm to " + getAction());
    }
}
