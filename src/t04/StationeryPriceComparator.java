package t04;

import t03.StationeryClass;

import java.util.Comparator;

public class StationeryPriceComparator implements Comparator<StationeryClass> {

    public int compare(StationeryClass one, StationeryClass two) {
        return one.getPrice() - two.getPrice();
    }
}
