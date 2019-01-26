package t04;

import t03.*;

import java.util.Comparator;

public class StationeryNameComparator implements Comparator<StationeryClass> {

    public int compare(StationeryClass one, StationeryClass two) {
        return one.getName().compareTo(two.getName());
    }
}
