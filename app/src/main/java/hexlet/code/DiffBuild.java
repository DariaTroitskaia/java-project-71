package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;

public class DiffBuild {
    public static Map<String, Object>  generateDiff(Map<String, Object> value1, Map<String, Object> value2) {
        Map<String, Object> data = new TreeMap<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(value1.keySet());
        keys.addAll(value2.keySet());
        for (var key : keys) {
            Map<Object, Object> keyData = new LinkedHashMap<>();

            if (value1.containsKey(key) && !value2.containsKey(key)) {
                keyData.put("type", "deleted");
                keyData.put("value", value1.get(key));
            } else if (value2.containsKey(key) && !value1.containsKey(key)) {
                keyData.put("type", "added");
                keyData.put("value", value2.get(key));
            } else if (Objects.equals(value1.get(key), value2.get(key))) {
                keyData.put("type", "unchanged");
                keyData.put("value", value1.get(key));
            } else {
                keyData.put("type", "changed");
                keyData.put("value1", value1.get(key));
                keyData.put("value2", value2.get(key));
            }

            data.put(key, keyData);
        }
        return data;
    }
}

