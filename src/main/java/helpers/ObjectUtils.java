package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectUtils {

	/**
     * Converts the values of a Map to a List of strings.
     *
     * @param object The Map object whose values are to be converted.
     * @return A List of strings containing the values from the Map.
     */
    public static List<String> getObjectValuesToList(Map<String, String> object) {
        List<String> values = new ArrayList<>();
        for (String key : object.keySet()) {
            // Ensure the key is actually present to mimic hasOwnProperty
            if (object.containsKey(key)) {
                values.add(object.get(key));
            }
        }
        return values;
    }

    /**
     * Creates a Map from two Lists, one representing keys and the other representing values.
     *
     * @param keys The List of keys.
     * @param values The List of values.
     * @return A Map representing the combined keys and values.
     */
    public static Map<String, String> getObjectFromTwoLists(List<String> keys, List<String> values) {
        Map<String, String> object = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            object.put(keys.get(i), values.get(i));
        }
        return object;
    }
}
