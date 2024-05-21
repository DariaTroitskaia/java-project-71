package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
public class DiffBuild {
    public static List<Map<String, Object>> generateDiff(Map<String, Object> value1, Map<String, Object> value2) {
        List<Map<String, Object>> data = new ArrayList<>(); 
        Set<String> keys = new TreeSet<>();
        keys.addAll(value1.keySet());
        keys.addAll(value2.keySet());
        for (var key : keys) {
            Map<String, Object> keyData = new LinkedHashMap<>();
            keyData.put("key", key);
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

            data.add(keyData);
        }
        return data;
    }
}

