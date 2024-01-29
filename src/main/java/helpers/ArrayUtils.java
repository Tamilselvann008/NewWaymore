package helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static List<String> getArrayWithoutAppropriateFields(List<String> array, List<String> fields) {
        return array.stream()
                    .filter(field -> !fields.contains(field))
                    .collect(Collectors.toList());
    }

    public static List<String> getDuplicatesFromArray(List<String> arr) {
        Set<String> duplicates = new HashSet<>();
        Set<String> uniqueItems = new HashSet<>();
        for (String item : arr) {
            if (!uniqueItems.add(item)) {
                duplicates.add(item);
            }
        }
        return duplicates.stream().collect(Collectors.toList());
    }

    public static List<String> getUniqueValuesFromArray(List<String> arr) {
        return new ArrayList<>(new HashSet<>(arr));
    }

    public static List<String> replaceValuesInArray(List<String> array, String oldValue, String newValue) {
        return array.stream()
                    .map(element -> element.replace(oldValue, newValue))
                    .collect(Collectors.toList());
    }
}

