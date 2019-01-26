package t03.storage;

import t03.StationeryClass;

import java.util.Scanner;

abstract class Storage extends StationeryClass {

    Scanner scanner = new Scanner(System.in);

    Storage(int price, String name) {
        super(price, name);
    }

    abstract void showAll();
}
