package t04;

import t03.BeginnerKit;
import t03.StationeryClass;

import java.util.Arrays;

public class StationeryComparator {

    public static void main(String[] args) {
        BeginnerKit beginnerKit = new BeginnerKit();
        StationeryClass[] kit = beginnerKit.getKit();

        System.out.println("Sorting by price: ");
        sortByPrice(kit);
        System.out.println();

        System.out.println("Sorting by name: ");
        sortByName(kit);
        System.out.println();

        System.out.println("Sorting by price then name: ");
        sortByPriceThenName(kit);
        System.out.println();
    }

    private static void sortByPrice(StationeryClass[] objects) {
        Arrays.sort(objects, new StationeryPriceComparator());

        printArray(objects);
    }

    private static void sortByName(StationeryClass[] objects) {
        Arrays.sort(objects, new StationeryNameComparator());

        printArray(objects);
    }

    private static void sortByPriceThenName(StationeryClass[] objects) {
        Arrays.sort(objects, new StationeryPriceComparator()
                .thenComparing(new StationeryNameComparator()));

        printArray(objects);
    }

    private static void printArray(StationeryClass[] objects) {
        for (StationeryClass object : objects) {
            System.out.println(object.getName() + " costs " + object.getPrice() + " roubles");
        }
    }
}
