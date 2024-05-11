package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;
import java.util.HashMap;

public class Parser {
    public static Map<String, Object> parse(String filepath, String format) throws Exception {
        if (format.equals("json")) {
            ObjectMapper mapperJson = new ObjectMapper();
            return stringToMapValues(mapperJson.readValue(filepath, Map.class));
        } else if (format.equals("yml") || format.equals("yaml")) {
            YAMLMapper mapperYML = new YAMLMapper();
            return stringToMapValues(mapperYML.readValue(filepath, Map.class));
        } else {
            throw new Exception("Please, use formats: .json, .yml, .yaml");
        }
    }

    private static Map stringToMapValues(Map<String, Object> data) {
        Map result = new HashMap<>();
        for (String key : data.keySet()) {
            Object value = data.get(key);
            result.put(key, value);
        }
        return result;
    }
}

