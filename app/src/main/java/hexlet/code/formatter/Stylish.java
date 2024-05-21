package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> maps) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        Object keyValue;
        for (Map map : maps) {
            String key = map.get("key").toString();
            String operand = map.get("type").toString();
            keyValue = map.get("value");
            switch (operand) {
                case "deleted":
                    builder.append("  - ").append(key).append(": ").append(keyValue).append("\n");
                    break;
                case "added":
                    builder.append("  + ").append(key).append(": ").append(keyValue).append("\n");
                    break;
                case "unchanged":
                    builder.append("    ").append(key).append(": ").append(keyValue).append("\n");
                    break;
                case "changed":
                    builder.append("  - ").append(key).append(": ").append(map.get("value1")).append("\n")
                            .append("  + ").append(key).append(": ").append(map.get("value2")).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unexpected value: " + operand);
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
