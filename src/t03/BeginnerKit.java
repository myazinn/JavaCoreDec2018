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


public class BeginnerKit {

    public Notebook notebook;
    public Stickers stickers;
    public Paper paper;
    public Pen redPen;
    public Pen blackPen;
    public Pencil pencil;
    public Scissors scissors;
    public Tape tape;
    public Stapler stapler;

    public BeginnerKit(){
        notebook =  new Notebook("My notebook");
        stickers = new Stickers("Don't forget");
        paper = new Paper();
        redPen = new Pen(Colors.RED, PenTypes.ROLLERBALL);
        blackPen = new Pen(Colors.BLACK, PenTypes.FOUNTAIN);
        pencil = new Pencil();
        scissors = new Scissors();
        tape = new Tape();
        stapler = new Stapler();
    }
}
