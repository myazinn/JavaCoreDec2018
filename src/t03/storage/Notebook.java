package t03.storage;

import t02.Stationery;

import java.util.ArrayList;

public class Notebook extends Storage {

    ArrayList<String> body = new ArrayList<>();

    public Notebook(){
        super(Stationery.NOTEBOOK.getPrice(), Stationery.NOTEBOOK.name());
    }
    public Notebook(String entry){
        this();
        body.add(entry);
    }

    public void use(){
        System.out.println("Write a string in notebook");
        body.add(scanner.next());
    }

    public void showAll() {
        body.forEach(System.out::println);
    }


}
