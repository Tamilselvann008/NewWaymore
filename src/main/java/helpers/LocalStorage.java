package helpers;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    private final static Map<String, String> storage = new HashMap<>();

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
     * Retrieves a value from the local storage simulator.
     * 
     * @param key The key of the value to be retrieved.
     * @return The value associated with the key, or null if the key does not exist.
     */
    public static String getItem(String key) {
        return storage.get(key);
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

