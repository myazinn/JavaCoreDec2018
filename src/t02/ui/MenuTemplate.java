package t02.ui;

import t02.db.SmartDB;

import java.util.Scanner;

abstract class MenuTemplate {
    Scanner scanner = new Scanner(System.in);
    SmartDB smartDB;

    MenuTemplate(SmartDB smartDB) {
        this.smartDB = smartDB;
    }

    abstract void createMenu();

    int getId() {
        System.out.println("Enter the ID of the employee");
        System.out.print("ID = ");
        return scanner.nextInt();
    }

    int getAmount() {
        System.out.println("How much?");
        System.out.print("amount = ");
        return scanner.nextInt();
    }

    String getStationery() {
        System.out.println("Enter a stationery");
        return scanner.next();
    }

    void commandPrinter(String[] strings){
        System.out.println();
        System.out.println("Available commands: ");

        for (int i = 0; i < strings.length; i++) {
            System.out.println((i+1) + " - " + strings[i]);
        }

        System.out.println();
        System.out.println("Enter a command");
    }
}
