package t02;

import t02.db.SmartDB;
import t02.ui.UserInterface;

public class DBDemo {
    public static void main(String[] args) {

        UserInterface ui = new UserInterface(new SmartDB());
        ui.start();

        System.out.println("Ended successfully");

    }
}
