package t03.actionInstruments;

import t02.Stationery;

public class Scissors extends ActionInstruments {
    public Scissors(){
        super(Stationery.SCISSORS.getPrice(), Stationery.SCISSORS.name(),"zip zip");
    }

    public void use(){
        System.out.println(getAction());
    }
}
