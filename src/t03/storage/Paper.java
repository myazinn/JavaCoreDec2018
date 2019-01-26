package t03.storage;

import t02.Stationery;

public class Paper extends Storage{
    private String entry;

    public Paper(){
        super(Stationery.PAPER.getPrice(), Stationery.PAPER.name());
    }
    public Paper(String entry) {
        this();
        this.entry = entry;
    }

    public void use() {
        entry = scanner.next();
    }

    public void showAll() {
        System.out.println(entry);
    }
}
