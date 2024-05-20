package hexlet.code.formatter;

import java.util.Map;

public class Stylish {
    public static String format(Map<String, Map<String, Object>> data) {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        Object keyValue;
        for (String key : data.keySet()) {
            Map<String, Object> keyData = data.get(key);
            String operand = keyData.get("type").toString();
            keyValue = keyData.get("value");
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
                    builder.append("  - ").append(key).append(": ").append(keyData.get("value1")).append("\n")
                            .append("  + ").append(key).append(": ").append(keyData.get("value2")).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unexpected value: " + operand);
            }
        }
        builder.append("}");
        return builder.toString();
    }
}
