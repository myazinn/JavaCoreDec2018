package t03.storage;

import t02.Stationery;

import java.util.HashSet;

public class Stickers extends Storage{

    private HashSet<String> stickers = new HashSet<>();

    public Stickers() {
        super(Stationery.STICKERS.getPrice(), Stationery.STICKERS.name());
    }

    public Stickers(String entry) {
        this();
        stickers.add(entry);
    }

    public void use() {
        System.out.println("Write a text on a sticker");
        stickers.add(scanner.next());
    }

    public void showAll() {
        stickers.forEach(System.out::println);
    }
}
