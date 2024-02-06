package helpers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalStorage {
    private final static Map<String, String> storage = new HashMap<>();
    private final static String SEPARATOR = ","; // Define a separator for list elements

    /**
     * Stores a value in the local storage simulator.
     * 
     * @param key The key under which the value is stored.
     * @param value The value to be stored.
     */
    public static void setItem(String key, String value) {
        storage.put(key, value);
    }

    /**
     * Overloaded method to store a list of strings.
     * 
     * @param key The key under which the list is stored.
     * @param list The list of strings to be stored.
     */
    public static void setItem(String key, List<String> list) {
        // Join the list into a single string with a separator
        String value = String.join(SEPARATOR, list);
        storage.put(key, value);
    }

    /**
     * Retrieves a value from the local storage simulator.
     * 
     * @param key The key of the value to be retrieved.
     * @return The value associated with the key, or null if the key does not exist.
     */
    public static String getItem(String key) {
        return storage.get(key);
    }

    /**
     * Overloaded method to retrieve a list of strings.
     * 
     * @param key The key of the list to be retrieved.
     * @return The list of strings associated with the key, or null if the key does not exist.
     */
    public static List<String> getItemList(String key) {
        String value = storage.get(key);
        if (value != null && !value.isEmpty()) {
            return Arrays.asList(value.split(SEPARATOR, -1));
        } else {
            return null;
        }
    }

    /**
     * Removes an item from the local storage simulator.
     * 
     * @param key The key of the item to remove.
     */
    public static void removeItem(String key) {
        storage.remove(key);
    }

    /**
     * Clears all items from the local storage simulator.
     */
    public static void clear() {
        storage.clear();
    }
}
