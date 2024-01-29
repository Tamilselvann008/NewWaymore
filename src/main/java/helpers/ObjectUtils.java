package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectUtils {
    public static List<String> getObjectValuesToArray(Map<String, String> object) {
        List<String> values = new ArrayList<>();
        for (Map.Entry<String, String> entry : object.entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    public static Map<String, String> getObjectFromTwoArrays(List<String> keys, List<String> values) {
        Map<String, String> object = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            object.put(keys.get(i), values.get(i));
        }
        return object;
    }
}
