package t02.ui;

import t02.db.SmartDB;

public class UserInterface {

    private SmartDB smartDB;

    /**
     * create interface where user can interact with database
     */
    public void start() {

        System.out.println("Let's begin");
        MainMenu mainMenu = new MainMenu(smartDB);
        mainMenu.createMenu();

    }

    public UserInterface(SmartDB smartDB) {
        this.smartDB = smartDB;
    }
}
