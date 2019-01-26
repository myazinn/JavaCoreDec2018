package t03;

import t01.Colors;
import t01.PenTypes;
import t03.actionInstruments.Scissors;
import t03.actionInstruments.Stapler;
import t03.actionInstruments.Tape;
import t03.drawingInstruments.Pen;
import t03.drawingInstruments.Pencil;
import t03.storage.Notebook;
import t03.storage.Paper;
import t03.storage.Stickers;

import java.util.Set;


public class BeginnerKit {

    Set<StationeryClass> beginnerSet;

    public BeginnerKit(){
        beginnerSet.add(new Notebook("My notebook"));
        beginnerSet.add(new Stickers("Don't forget"));
        beginnerSet.add(new Paper());
        beginnerSet.add(new Pen(Colors.RED, PenTypes.ROLLERBALL));
        beginnerSet.add(new Pen(Colors.BLACK, PenTypes.FOUNTAIN));
        beginnerSet.add(new Pencil());
        beginnerSet.add(new Scissors());
        beginnerSet.add(new Tape());
        beginnerSet.add(new Stapler());
    }
}
