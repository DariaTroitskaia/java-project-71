package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> content(String content, String format) throws Exception {
        switch (format) {
            case "json" -> {
                ObjectMapper mapperJson = new ObjectMapper();
                return mapperJson.readValue(content, Map.class);
            }
            case "yml", "yaml" -> {
                YAMLMapper mapperYML = new YAMLMapper();
                return mapperYML.readValue(content, Map.class);
            }
            default -> throw new Exception("Please, use formats: .json, .yml, .yaml");
        }
    }
}

