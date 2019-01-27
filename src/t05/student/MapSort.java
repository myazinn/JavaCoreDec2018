package t05.student;

/*
I found this code on StackOverflow (https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values)
I tried to write a code that will sort a map by value, but it wasn't as good as this implementation.
That's why I decided to use this code.
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class MapSort {
    static <K, V extends Comparable<? super V>> Map<K, V> decreaseOrder(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> kvEntry : list) {
            result.put(kvEntry.getKey(), kvEntry.getValue());
        }

        return result;
    }
}
