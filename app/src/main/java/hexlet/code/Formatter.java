package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getOutputText(List<Map<String, Object>> difference, String format)
            throws JsonProcessingException {
        String outputText = switch (format) {
            case "stylish" -> Stylish.format(difference);
            case "json" -> Json.format(difference);
            case "plain" -> Plain.format(difference);
            default -> throw new RuntimeException("no such format, try plain, stylish or json");
        };
        return outputText;
    }
}

