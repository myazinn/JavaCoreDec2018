package t03.actionInstruments;

import t02.Stationery;

public class Stapler extends ActionInstruments {
    public Stapler() {
        super(Stationery.STAPLER.getPrice(), Stationery.STAPLER.name(),"Stap!");
    }

    public void use() {
        System.out.println(getAction());
    }
}
