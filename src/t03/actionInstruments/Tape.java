package t03.actionInstruments;

import t02.Stationery;

public class Tape extends ActionInstruments {
    public Tape(){
        super(Stationery.TAPE.getPrice(), "taped!");
    }

    public void use(){
        System.out.println(getAction());
    }
}
